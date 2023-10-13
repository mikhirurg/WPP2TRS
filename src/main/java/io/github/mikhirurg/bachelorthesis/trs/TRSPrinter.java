package io.github.mikhirurg.bachelorthesis.trs;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileNot;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print.WhilePrint;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return trs;
    }

    private List<TRSTerm> buildVars() {
        List<TRSTerm> vars = new ArrayList<>();

        for (int i = 0; i < state.getVars().size(); i++) {
            vars.add(null);
        }

        for (WhileVar var : state.getVars().keySet()) {
            vars.set(state.getPosition().get(var), new TRSVariable(var.getVarName()));
        }

        vars.add(new TRSVariable("in"));
        vars.add(new TRSVariable("out"));

        return vars;
    }

    public void visitAssignment(WhileAssignment assignment) {
        List<TRSTerm> leftVars = buildVars();

        List<TRSTerm> rightVars = new ArrayList<>(leftVars);
        rightVars.set(state.getPosition().get(assignment.getVariable()),
                new TRSVariable(assignment.getExpression().toString()));

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
        int i = state.getI();
        int index = trs.size();

        State copy = new State(state);

        whileIf.getStatement1().acceptTRSPrinter(this);
        trs.get(index).setCondition(whileIf.getCondition().toString());

        state.setI(i);

        index = trs.size();
        state = new State(copy);

        whileIf.getStatement2().acceptTRSPrinter(this);
        trs.get(index).setCondition(new WhileNot(whileIf.getCondition()).toString());

        state = new State(copy);
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
                new TRSVariable( declaration.getExpression().toString()));

        TRSFunction left = new TRSFunction("stm_" + state.getI(), leftVars);
        state.setI(state.getI() + 1);
        TRSFunction right = new TRSFunction("stm_" + state.getI(), rightVars);

        trs.add(new TRSRule(left, right));
    }

    public void visitWhile(WhileWhile whileWhile) {
        List<TRSTerm> leftVars = buildVars();
        TRSTerm left = new TRSFunction("stm_" + state.getI(), leftVars);

        int index = trs.size() - 1;

        State copy = new State(state);
        whileWhile.getStatement().acceptTRSPrinter(this);

        TRSTerm right = trs.get(index).getLeft();

        trs.add(new TRSRule(left, right, whileWhile.getCondition().toString()));

        leftVars = buildVars();
        left = new TRSFunction("stm_" + state.getI(), leftVars);
        right = trs.get(index).getLeft();

        trs.add(new TRSRule(left, right, whileWhile.getCondition().toString()));

        state.setI(state.getI() + 1);
        copy.setI(copy.getI() + 1);
        List<TRSTerm> rightVars = buildVars();
        right = new TRSFunction("stm_" + state.getI(), rightVars);

        trs.add(new TRSRule(left, right, new WhileNot(whileWhile.getCondition()).toString()));
        copy.setI(copy.getI() + 1);

        state = new State(copy);
    }

    public void visitPrint(WhilePrint whilePrint) {
        List<TRSTerm> leftVars = buildVars();
        TRSTerm left = new TRSFunction("stm_" + state.getI(), leftVars);

        state.setI(state.getI() + 1);

        List<TRSTerm> rightVars = buildVars();
        rightVars.set(rightVars.size() - 1, new TRSVariable("out ++ "+ whilePrint.getExpression().toString()));
        TRSTerm right = new TRSFunction("stm_" + state.getI(), rightVars);

        trs.add(new TRSRule(left, right));
    }
}
