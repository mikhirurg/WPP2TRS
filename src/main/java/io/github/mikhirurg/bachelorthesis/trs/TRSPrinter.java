package io.github.mikhirurg.bachelorthesis.trs;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileNot;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print.WhilePrint;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.*;

public class TRSPrinter {
    private static class State {
        private final Map<WhileVar, Object> vars;

        private final Map<WhileVar, Integer> position;

        private final List<String> out;

        private final List<String> in;

        private int i;

        public State() {
            this.vars = new HashMap<>();
            this.out = new ArrayList<>();
            this.in = new ArrayList<>();
            this.position = new HashMap<>();
            this.i = 0;
        }

        public State(State other) {
            this.vars = new HashMap<>(other.vars);
            this.out = new ArrayList<>(other.out);
            this.in = new ArrayList<>(other.in);
            this.position = new HashMap<>(other.position);
            this.i = other.getI();
        }

        public List<String> getOut() {
            return out;
        }

        public List<String> getIn() {
            return in;
        }

        public Map<WhileVar, Integer> getPosition() {
            return position;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public Map<WhileVar, Object> getVars() {
            return vars;
        }
    }

    private State state;

    private final List<TRSRule> trs;

    public TRSPrinter() {
        this.state = new State();
        this.trs = new ArrayList<>();
    }

    public List<TRSRule> getTRSRules() {
        List<TRSRule> rules = new ArrayList<>(trs);

        List<TRSTerm> leftVars = buildVars();
        TRSFunction left = new TRSFunction("stm_" + state.getI(), leftVars, WhileType.STRING.getName());
        TRSVariable right = new TRSVariable("out", WhileType.STRING.getName());

        rules.add(new TRSRule(left, right));
        return rules;
    }

    public String getRulesRepresentation() {
        List<TRSRule> rules = new ArrayList<>(getTRSRules());

        rules.sort(Comparator.comparingInt(o -> Integer.parseInt(((TRSFunction) o.getLeft()).getName()
                .substring(4))));

        String name = "";
        String type = "";

        StringBuilder builder = new StringBuilder();
        StringBuilder signatureBuilder = new StringBuilder();

        for (TRSRule rule : rules) {
            if (!name.equals(((TRSFunction) rule.getLeft()).getName()) || !type.equals(rule.getRight().getType())) {
                if (!builder.isEmpty()) {
                    builder.append("\n");
                }

                name = ((TRSFunction) rule.getLeft()).getName();
                type = rule.getRight().getType();

                signatureBuilder.append(name).append(" :: ");
                for (TRSTerm trsTerm : ((TRSFunction) rule.getLeft()).getTerms()) {
                    signatureBuilder.append(trsTerm.getType()).append(" -> ");
                }
                signatureBuilder.append(rule.getRight().getType());
                builder.append(signatureBuilder).append("\n");

                signatureBuilder.setLength(0);
            }
            builder.append(rule).append("\n");
        }

        builder.setLength(builder.length() - 1);

        return builder.toString();
    }

    private List<TRSTerm> buildVars() {
        List<TRSTerm> vars = new ArrayList<>();

        for (int i = 0; i < state.getVars().size(); i++) {
            vars.add(null);
        }

        for (WhileVar var : state.getVars().keySet()) {
            vars.set(state.getPosition().get(var), new TRSVariable(var.getVarName(), var.getType().getName()));
        }

        vars.add(new TRSVariable("in", WhileType.STRING.getName()));
        vars.add(new TRSVariable("out", WhileType.STRING.getName()));

        return vars;
    }

    public void visitAssignment(WhileAssignment assignment) {
        List<TRSTerm> leftVars = buildVars();

        List<TRSTerm> rightVars = new ArrayList<>(leftVars);
        rightVars.set(state.getPosition().get(assignment.getVariable()),
                new TRSVariable(assignment.getExpression().toString(), assignment.getVariable().getType().getName()));

        TRSFunction left = new TRSFunction("stm_" + state.getI(), leftVars);
        state.setI(state.getI() + 1);
        TRSFunction right = new TRSFunction("stm_" + state.getI(), rightVars);

        trs.add(new TRSRule(left, right));
    }

    public void visitComp(WhileComp comp) {
        comp.getStatement1().acceptTRSPrinter(this);
        comp.getStatement2().acceptTRSPrinter(this);
    }

    public void visitIf(WhileIf whileIf) {
        int i;
        int index1 = trs.size();

        State copy = new State(state);

        // Signature: s, i = i_1
        whileIf.getStatement1().acceptTRSPrinter(this);
        TRSTerm left = new TRSFunction("stm_" + state.getI(), buildVars());
        TRSTerm right = new TRSVariable("", "");
        trs.add(new TRSRule(left, right));
        int endBranch1 = trs.size() - 1;

        // Signature: s', i = i_2
        trs.get(index1).setCondition(whileIf.getCondition().toString());

        // Setting i = i_1
        int oldI = copy.getI();

        i = state.getI();
        int index2 = trs.size();

        state = new State(copy);
        state.setI(i);

        whileIf.getStatement2().acceptTRSPrinter(this);
        left = new TRSFunction("stm_" + state.getI(), buildVars());
        right = new TRSVariable("", "");
        trs.add(new TRSRule(left, right));
        int endBranch2 = trs.size() - 1;

        trs.get(index2).setCondition(new WhileNot(whileIf.getCondition()).toString());
        trs.get(index2).setLeft(trs.get(index1).getLeft());

        state.setI(state.getI() + 1);
        copy.setI(state.getI());

        state = new State(copy);

        right = new TRSFunction("stm_" + state.getI(), buildVars());
        trs.get(endBranch1).setRight(right);
        trs.get(endBranch2).setRight(right);
    }

    public void visitSkip(WhileSkip skip) {
        // Do nothing
    }

    public void visitDeclaration(WhileVarDeclaration declaration) {
        List<TRSTerm> leftVars = buildVars();

        state.getVars().put(declaration.getVariable(), declaration.getExpression());
        state.getPosition().put(declaration.getVariable(), state.getVars().size() - 1);

        List<TRSTerm> rightVars = buildVars();
        rightVars.set(state.getPosition().get(declaration.getVariable()),
                new TRSVariable(declaration.getExpression().toString(), declaration.getVariable().getType().getName()));

        TRSFunction left = new TRSFunction("stm_" + state.getI(), leftVars);
        state.setI(state.getI() + 1);
        TRSFunction right = new TRSFunction("stm_" + state.getI(), rightVars);

        trs.add(new TRSRule(left, right));
    }

    public void visitWhile(WhileWhile whileWhile) {
        List<TRSTerm> leftVars = buildVars();
        new TRSFunction("stm_" + state.getI(), leftVars);
        TRSTerm left;

        int index = trs.size();

        State copy = new State(state);
        whileWhile.getStatement().acceptTRSPrinter(this);

        TRSTerm right;

        trs.get(index).setCondition(whileWhile.getCondition().toString());

        leftVars = buildVars();
        left = new TRSFunction("stm_" + state.getI(), leftVars);
        right = trs.get(index).getLeft();

        trs.add(new TRSRule(left, right, whileWhile.getCondition().toString()));

        state.setI(state.getI() + 1);
        copy.setI(state.getI());

        state = new State(copy);

        List<TRSTerm> rightVars = buildVars();
        right = new TRSFunction("stm_" + state.getI(), rightVars);

        trs.add(new TRSRule(left, right, new WhileNot(whileWhile.getCondition()).toString()));

        left = trs.get(index).getLeft();
        trs.add(new TRSRule(left, right, new WhileNot(whileWhile.getCondition()).toString()));
    }

    public void visitPrint(WhilePrint whilePrint) {
        List<TRSTerm> leftVars = buildVars();
        TRSTerm left = new TRSFunction("stm_" + state.getI(), leftVars);

        state.setI(state.getI() + 1);

        List<TRSTerm> rightVars = buildVars();
        rightVars.set(rightVars.size() - 1, new TRSVariable("out ++ "+ whilePrint.getExpression().toString(),
                WhileType.STRING.getName()));
        TRSTerm right = new TRSFunction("stm_" + state.getI(), rightVars);

        trs.add(new TRSRule(left, right));
    }
}
