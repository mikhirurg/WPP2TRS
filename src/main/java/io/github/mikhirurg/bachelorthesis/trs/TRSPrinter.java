package io.github.mikhirurg.bachelorthesis.trs;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileNot;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print.WhilePrint;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read.WhileRead;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.*;
import java.util.stream.Collectors;

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

    private final static String LIST_RULES =
            """
            nil :: list
            consI :: Int -> list -> list
            consB :: Bool -> list -> list
            consS :: String -> list -> list
            
            appendI :: Int -> list -> list
            appendB :: Bool -> list -> list
            appendS :: String -> list -> list
            
            takeI :: list -> Int
            takeB :: list -> Bool
            takeS :: list -> String
            
            moveI :: list -> list
            moveB :: list -> list
            moveS :: list -> list

            appendI(i, l) -> consI(i, l)
            appendB(b, l) -> consB(b, l)
            appendS(str, l) -> consS(str, l)

            takeI(consI(i, l)) -> i
            takeB(consB(b, l)) -> b
            takeS(consS(str, l)) -> str

            moveI(consI(i, l)) -> l
            moveB(consB(b, l)) -> l
            moveS(consS(str, l)) -> l
            
            """;
    private State state;

    private final List<TRSRule> trs;

    public TRSPrinter() {
        this.state = new State();
        this.trs = new ArrayList<>();
    }

    public List<TRSRule> getTRSRules() {
        List<TRSRule> rules = new ArrayList<>(trs);

        List<TRSTerm> leftVars = buildVars();
        TRSFunction left = new TRSFunction("stm_" + state.getI(), leftVars, WhileType.LIST.getName());
        TRSVariable right = new TRSVariable("out", WhileType.LIST.getName());

        rules.add(new TRSRule(left, right));
        return rules;
    }

    public String getRulesRepresentation() {
        List<TRSRule> rules = new ArrayList<>(getTRSRules());

        rules.sort(Comparator.comparingInt(o -> Integer.parseInt(((TRSFunction) o.getLeft()).getName()
                .substring(4))));

        String name = "";
        String type;

        StringBuilder builder = new StringBuilder(LIST_RULES);
        StringBuilder signatureBuilder = new StringBuilder();

        for (TRSRule rule : rules) {
            if (!((TRSFunction)rule.getLeft()).getName().equals(name)) {
                name = ((TRSFunction) rule.getLeft()).getName();
                type = rule.getRight().getType();

                signatureBuilder.append(name).append(" :: ");
                for (TRSTerm trsTerm : ((TRSFunction) rule.getLeft()).getTerms()) {
                    signatureBuilder.append(trsTerm.getType()).append(" -> ");
                }
                signatureBuilder.append(type);
                builder.append(signatureBuilder).append("\n");

                signatureBuilder.setLength(0);
            }
        }

        builder.append("\n");

        for (TRSRule rule : rules) {
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

        vars.add(new TRSVariable("in", WhileType.LIST.getName()));
        vars.add(new TRSVariable("out", WhileType.LIST.getName()));

        return vars;
    }

    public void visitAssignment(WhileAssignment assignment) {
        List<TRSTerm> leftVars = buildVars();

        List<TRSTerm> rightVars = new ArrayList<>(leftVars);
        rightVars.set(state.getPosition().get(assignment.getVariable()),
                new TRSVariable(assignment.getExpression().toString(), assignment.getVariable().getType().getName()));

        TRSFunction left = new TRSFunction("stm_" + state.getI(), leftVars, WhileType.LIST.getName());
        state.setI(state.getI() + 1);
        TRSFunction right = new TRSFunction("stm_" + state.getI(), rightVars, WhileType.LIST.getName());

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
        TRSTerm left = new TRSFunction("stm_" + state.getI(), buildVars(), WhileType.LIST.getName());
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
        left = new TRSFunction("stm_" + state.getI(), buildVars(), WhileType.LIST.getName());
        right = new TRSVariable("", "");
        trs.add(new TRSRule(left, right));
        int endBranch2 = trs.size() - 1;

        trs.get(index2).setCondition(new WhileNot(whileIf.getCondition()).toString());
        trs.get(index2).setLeft(trs.get(index1).getLeft());

        state.setI(state.getI() + 1);
        copy.setI(state.getI());

        state = new State(copy);

        right = new TRSFunction("stm_" + state.getI(), buildVars(), WhileType.LIST.getName());
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

        TRSFunction left = new TRSFunction("stm_" + state.getI(), leftVars, WhileType.LIST.getName());
        state.setI(state.getI() + 1);
        TRSFunction right = new TRSFunction("stm_" + state.getI(), rightVars, WhileType.LIST.getName());

        trs.add(new TRSRule(left, right));
    }

    public void visitWhile(WhileWhile whileWhile) {
        List<TRSTerm> leftVars = buildVars();
        new TRSFunction("stm_" + state.getI(), leftVars, WhileType.LIST.getName());
        TRSTerm left;

        int index = trs.size();

        State copy = new State(state);
        whileWhile.getStatement().acceptTRSPrinter(this);

        TRSTerm right;

        trs.get(index).setCondition(whileWhile.getCondition().toString());

        leftVars = buildVars();
        left = new TRSFunction("stm_" + state.getI(), leftVars, WhileType.LIST.getName());
        right = trs.get(index).getLeft();

        trs.add(new TRSRule(left, right, whileWhile.getCondition().toString()));

        state.setI(state.getI() + 1);
        copy.setI(state.getI());

        state = new State(copy);

        List<TRSTerm> rightVars = buildVars();
        right = new TRSFunction("stm_" + state.getI(), rightVars, WhileType.LIST.getName());

        trs.add(new TRSRule(left, right, new WhileNot(whileWhile.getCondition()).toString()));

        left = trs.get(index).getLeft();
        trs.add(new TRSRule(left, right, new WhileNot(whileWhile.getCondition()).toString()));
    }

    public void visitPrint(WhilePrint whilePrint) {
        List<TRSTerm> leftVars = buildVars();
        TRSTerm left = new TRSFunction("stm_" + state.getI(), leftVars, WhileType.LIST.getName());

        state.setI(state.getI() + 1);

        String appendType = switch (whilePrint.getExpression().getType()) {
            case INT -> "appendI";
            case BOOL -> "appendB";
            case STRING -> "appendS";
            default -> "";
        };

        List<TRSTerm> rightVars = buildVars();
        rightVars.set(rightVars.size() - 1, new TRSVariable(appendType + "("+ whilePrint.getExpression().toString() +
                ", out)", WhileType.LIST.getName()));
        TRSTerm right = new TRSFunction("stm_" + state.getI(), rightVars, WhileType.LIST.getName());

        trs.add(new TRSRule(left, right));
    }

    public void visitRead(WhileRead whileRead) {
        List<TRSTerm> leftVars = buildVars();
        TRSTerm left = new TRSFunction("stm_" + state.getI(), leftVars, WhileType.LIST.getName());

        state.setI(state.getI() + 1);

        String takeType = switch (whileRead.getVariable().getType()) {
            case INT -> "takeI";
            case BOOL -> "takeB";
            case STRING -> "takeS";
            default -> "";
        };

        String moveType = switch (whileRead.getVariable().getType()) {
            case INT -> "moveI";
            case BOOL -> "moveB";
            case STRING -> "moveS";
            default -> "";
        };

        List<TRSTerm> rightVars = buildVars();
        rightVars.set(state.position.get(whileRead.getVariable()), new TRSVariable(takeType + "(in)",
                whileRead.getVariable().getType().getName()));
        rightVars.set(rightVars.size() - 2, new TRSVariable(moveType + "(in)", WhileType.LIST.getName()));

        TRSTerm right = new TRSFunction("stm_" + state.getI(), rightVars, WhileType.LIST.getName());

        trs.add(new TRSRule(left, right));
    }
}
