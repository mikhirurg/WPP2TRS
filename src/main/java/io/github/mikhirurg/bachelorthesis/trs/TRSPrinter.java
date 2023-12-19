package io.github.mikhirurg.bachelorthesis.trs;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileNot;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print.WhilePrint;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read.WhileRead;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileListVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.antlr.v4.runtime.misc.OrderedHashSet;

import java.util.*;

public class TRSPrinter {
    private static class State {
        private final Map<WhileVar, Object> vars;

        private final Map<WhileVar, Integer> position;

        private final List<Integer> ids;

        private int i;

        public State() {
            this.vars = new HashMap<>();
            this.position = new HashMap<>();
            this.ids = new ArrayList<>();
            this.i = 0;
        }

        public State(State other) {
            this.vars = new HashMap<>(other.vars);
            this.position = new HashMap<>(other.position);
            this.ids = new ArrayList<>(other.ids);
            this.i = other.getI();
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

        public List<Integer> getIds() {
            return ids;
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

    private final WhileVar IN = new WhileListVar("in");

    private final WhileVar OUT = new WhileListVar("out");

    public TRSPrinter() {
        this.state = new State();
        this.trs = new ArrayList<>();

        addVariableToSignature(IN, null);
        addVariableToSignature(OUT, null);
    }

    public List<TRSRule> getTRSRules() {
        List<TRSRule> rules = new ArrayList<>(trs);

        List<TRSTerm> leftVars = buildVars();
        TRSFunction left = new TRSFunction(((TRSFunction )trs.get(trs.size() - 1).getRight()).getName(), leftVars, WhileType.LIST.getName());
        TRSVariable right = new TRSVariable("out", WhileType.LIST.getName());

        rules.add(new TRSRule(left, right));
        return rules;
    }

    public String getRulesRepresentation() {
        List<TRSRule> rules = new ArrayList<>(getTRSRules());

        String name = "";
        String type;

        StringBuilder builder = new StringBuilder(LIST_RULES);
        StringBuilder signatureBuilder = new StringBuilder();

        Set<String> signatures = new OrderedHashSet<>();

        for (TRSRule rule : rules) {
            if (!((TRSFunction) rule.getLeft()).getName().equals(name)) {
                name = ((TRSFunction) rule.getLeft()).getName();
                type = rule.getRight().getType();

                signatureBuilder.append(name).append(" :: ");
                for (TRSTerm trsTerm : ((TRSFunction) rule.getLeft()).getTerms()) {
                    signatureBuilder.append(trsTerm.getType()).append(" -> ");
                }
                signatureBuilder.append(type);

                signatures.add(signatureBuilder.toString());

                signatureBuilder.setLength(0);
            }
        }

        for (String signature : signatures) {
            builder.append(signature).append("\n");
        }

        builder.append("\n");

        for (TRSRule rule : rules) {
            builder.append(rule).append("\n");
        }

        builder.setLength(builder.length() - 1);

        return builder.toString();
    }

    private void updateVariable(List<TRSTerm> terms, WhileVar var, TRSVariable trsVariable) {
        terms.set(state.getPosition().get(var), trsVariable);
    }

    private void addVariableToSignature(WhileVar var, WhileExpression whileExpression) {
        state.getVars().put(var, whileExpression);
        state.getPosition().put(var, state.getVars().size() - 1);
    }

    private List<TRSTerm> buildVars() {
        List<TRSTerm> vars = new ArrayList<>();

        for (int i = 0; i < state.getVars().size(); i++) {
            vars.add(null);
        }

        for (WhileVar var : state.getVars().keySet()) {
            vars.set(state.getPosition().get(var), new TRSVariable(var.getVarName(), var.getType().getName()));
        }

        return vars;
    }

    public void visitSkip(WhileSkip skip) {

        // 1) Creating left side of the rule:

        // 1.1) Creating name for the left side:
        String leftName = "stm_" + skip.getId() + "_0";

        // 1.2) Creating arguments for the left side:
        List<TRSTerm> leftArgs = buildVars();

        // 1.3) Create left term:
        TRSTerm left = new TRSFunction(leftName, leftArgs, WhileType.LIST.getName());

        // 2) Creating right side of the rule

        // 2.1) Creating name for the right side
        String rightName = "stm_" + skip.getId() + "_1";

        // 2.2) Creating arguments for the right side
        List<TRSTerm> rightArgs = buildVars();

        // 2.3) Creating right term
        TRSTerm right = new TRSFunction(rightName, rightArgs, WhileType.LIST.getName());

        // 3) Adding new rule
        trs.add(new TRSRule(left, right));

        state.getIds().add(skip.getId());
    }

    public void visitDeclaration(WhileVarDeclaration declaration) {

        // 1) Creating left side of the rule:

        // 1.1) Creating name for the left side:
        String leftName = "stm_" + declaration.getId() + "_0";

        // 1.2) Creating arguments for the left side:
        List<TRSTerm> leftVars = buildVars();

        // 1.3) Create left term:
        TRSFunction left = new TRSFunction(leftName, leftVars, WhileType.LIST.getName());

        // 2) Creating right side of the rule

        // 2.1) Creating name for the right side
        String rightName = "stm_" + declaration.getId() + "_1";

        // 2.2) Creating arguments for the right side

        // 2.2.1) Adding variable to the signature
        addVariableToSignature(declaration.getVariable(), declaration.getExpression());

        // 2.2.2) Creating variables with the information from the state:
        List<TRSTerm> rightVars = buildVars();
        updateVariable(rightVars,
                declaration.getVariable(),
                new TRSVariable(declaration.getExpression().toString(),
                        declaration.getVariable().getType().getName())
        );

        // 2.3) Creating right term
        TRSFunction right = new TRSFunction(rightName, rightVars, WhileType.LIST.getName());

        // 3) Adding new rule
        trs.add(new TRSRule(left, right));

        state.getIds().add(declaration.getId());
    }

    public void visitAssignment(WhileAssignment assignment) {
        // 1) Creating left side of the rule:

        // 1.1) Creating name for the left side:
        String leftName = "stm_" + assignment.getId() + "_0";

        // 1.2) Creating arguments for the left side:
        List<TRSTerm> leftVars = buildVars();

        // 1.3) Create left term:
        TRSFunction left = new TRSFunction(leftName, leftVars, WhileType.LIST.getName());

        // 2) Creating right side of the rule

        // 2.1) Creating name for the right side
        String rightName = "stm_" + assignment.getId() + "_1";

        // 2.2) Creating arguments for the right side
        List<TRSTerm> rightVars = new ArrayList<>(leftVars);
        updateVariable(rightVars,
                assignment.getVariable(),
                new TRSVariable(assignment.getExpression().toString(),
                        assignment.getVariable().getType().getName())
        );

        // 2.3) Creating right term
        TRSFunction right = new TRSFunction(rightName, rightVars, WhileType.LIST.getName());

        // 3) Adding new rule
        trs.add(new TRSRule(left, right));

        state.getIds().add(assignment.getId());
    }

    public void visitPrint(WhilePrint whilePrint) {

        // 1) Creating left side of the rule:

        // 1.1) Creating name for the left side:
        String leftName = "stm_" + whilePrint.getId() + "_0";

        // 1.2) Creating arguments for the left side:
        List<TRSTerm> leftVars = buildVars();

        // 1.3) Create left term:
        TRSTerm left = new TRSFunction(leftName, leftVars, WhileType.LIST.getName());

        // 2) Creating right side of the rule

        // 2.1) Creating name for the right side
        String rightName = "stm_" + whilePrint.getId() + "_1";

        // 2.2) Creating arguments for the right side
        List<TRSTerm> rightVars = buildVars();

        String appendType = switch (whilePrint.getExpression().getType()) {
            case INT -> "appendI";
            case BOOL -> "appendB";
            case STRING -> "appendS";
            default -> "";
        };

        updateVariable(rightVars, OUT,
                new TRSVariable(appendType + "(" + whilePrint.getExpression().toString() +
                        ", out)", WhileType.LIST.getName())
        );

        // 2.3) Creating right term
        TRSTerm right = new TRSFunction(rightName, rightVars, WhileType.LIST.getName());

        // 3) Adding new rule
        trs.add(new TRSRule(left, right));

        state.getIds().add(whilePrint.getId());
    }

    public void visitRead(WhileRead whileRead) {

        // 1) Creating left side of the rule:

        // 1.1) Creating name for the left side:
        String leftName = "stm_" + whileRead.getId() + "_0";

        // 1.2) Creating arguments for the left side:
        List<TRSTerm> leftVars = buildVars();

        // 1.3) Create left term:
        TRSTerm left = new TRSFunction(leftName, leftVars, WhileType.LIST.getName());

        // 2) Creating right side of the rule

        // 2.1) Creating name for the right side
        String rightName = "stm_" + whileRead.getId() + "_1";

        // 2.2) Creating arguments for the right side
        List<TRSTerm> rightVars = buildVars();

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

        updateVariable(rightVars,
                whileRead.getVariable(),
                new TRSVariable(takeType + "(in)",
                        whileRead.getVariable().getType().getName())
        );

        updateVariable(rightVars, IN,
                new TRSVariable(moveType + "(in)", WhileType.LIST.getName())
        );

        // 2.3) Creating right term
        TRSTerm right = new TRSFunction(rightName, rightVars, WhileType.LIST.getName());

        // 3) Adding new rule
        trs.add(new TRSRule(left, right));

        state.getIds().add(whileRead.getId());
    }

    public void visitComp(WhileComp comp) {

        // Exploring statement 1:
        comp.getStatement1().acceptTRSPrinter(this);

        // 1) Creating left side of the rule:

        // 1.1) Creating name for the left side:
        String leftName = ((TRSFunction) trs.get(trs.size() - 1).getRight()).getName();

        // 1.2) Creating arguments for the left side:
        List<TRSTerm> leftVars = buildVars();

        // 1.3) Create left term:
        TRSTerm left = new TRSFunction(leftName, leftVars, WhileType.LIST.getName());

        // Saving the size of the LCTRS rules array:
        int trsSize = trs.size();

        // Exploring statement 2:
        comp.getStatement2().acceptTRSPrinter(this);

        // 2) Creating right side of the rule

        // 2.1) Creating name for the right side
        String rightName = ((TRSFunction) trs.get(trsSize).getLeft()).getName();

        // 2.2) Creating arguments for the right side
        List<TRSTerm> rightVars = new ArrayList<>(leftVars);

        // 2.3) Creating right term
        TRSTerm right = new TRSFunction(rightName, rightVars, WhileType.LIST.getName());

        // 3) Adding new rule
        trs.add(trsSize, new TRSRule(left, right));
    }

    public void visitIf(WhileIf whileIf) {

        // Copying the state:
        State stateCopy = new State(state);

        // Case 1: if condition evaluates to true

        // 1.1) Creating name for the left side:
        String leftName = "stm_" + whileIf.getId() + "_0";

        // 1.2) Creating arguments for the left side:
        List<TRSTerm> leftVars = buildVars();

        // 1.3) Create left term:
        TRSTerm left = new TRSFunction(leftName, leftVars, WhileType.LIST.getName());

        // Saving size of the trs list:
        int trsSize = trs.size();

        // Exploring statement 1:
        whileIf.getStatement1().acceptTRSPrinter(this);

        // Saving arguments after statement 1:
        List<TRSTerm> varsStatement1 = buildVars();

        // Saving name of the right function symbol for the last rule
        String rightNameStatement1 = ((TRSFunction) trs.get(trs.size() - 1).getRight()).getName();

        trs.add(trsSize,
                new TRSRule(left,
                        trs.get(trsSize).getLeft(),
                        whileIf.getCondition().toString()));

        state = new State(stateCopy);

        // Case 2: if condition evaluates to false

        // Saving size of the trs list:
        trsSize = trs.size();

        // Exploring statement 2:
        whileIf.getStatement2().acceptTRSPrinter(this);

        // Saving arguments after statement 2:
        List<TRSTerm> varsStatement2 = buildVars();

        // Saving name of the right function symbol for the last rule
        String rightNameStatement2 = ((TRSFunction) trs.get(trs.size() - 1).getRight()).getName();

        trs.add(trsSize,
                new TRSRule(left,
                        trs.get(trsSize).getLeft(),
                        new WhileNot(whileIf.getCondition()).toString()
                        ));

        state = new State(stateCopy);

        // Adding finalizing rules (to move from the sub-statement of the if)
        trs.add(new TRSRule(
           new TRSFunction(rightNameStatement1, varsStatement1, WhileType.LIST.getName()),
           new TRSFunction("stm_" + whileIf.getId() + "_1", buildVars(), WhileType.LIST.getName())
        ));

        trs.add(new TRSRule(
                new TRSFunction(rightNameStatement2, varsStatement2, WhileType.LIST.getName()),
                new TRSFunction("stm_" + whileIf.getId() + "_1", buildVars(), WhileType.LIST.getName())
        ));

        state.setI(whileIf.getId());
    }


    public void visitWhile(WhileWhile whileWhile) {

        // Saving size of the id array, to make the connection:
        int idsSize = state.getIds().size();

        // Saving arguments:
        List<TRSTerm> vars = buildVars();

        // Copying the state:
        State stateCopy = new State(state);

        // Saving the size of the LCTRS array
        int trsSize = trs.size();

        // Exploring While statement:
        // [[S]]_{id_1, x^->}

        whileWhile.getStatement().acceptTRSPrinter(this);

        // Case 1: while condition evaluates to true
        // stm_{id, 0}[x^->] -> ([[S]]_{id_1, x^->}[0].l) [b]

        // 1) Creating left side of the rule:

        // 1.1) Creating name for the left side:
        String leftName = "stm_" + whileWhile.getId() + "_0";

        // 1.2) Creating arguments for the left side:
        List<TRSTerm> leftVars = new ArrayList<>(vars);

        // 1.3) Create left term:
        TRSTerm left = new TRSFunction(leftName, leftVars, WhileType.LIST.getName());

        // 2) Creating right side of the rule (while condition evaluates to true)

        // 2.1) Creating name for the right side
        String rightName = "stm_" + state.getIds().get(idsSize) + "_0";

        // 2.2) Creating arguments for the right side
        List<TRSTerm> rightVars = new ArrayList<>(leftVars);

        // 2.3) Creating right term
        TRSTerm right = new TRSFunction(rightName, rightVars, WhileType.LIST.getName());

        // 3) Adding new rule
        trs.add(trsSize, new TRSRule(left, right, whileWhile.getCondition().toString()));

        // Case 2: while condition evaluates to false
        // stm_{id, 0}[x^->] -> stm_{id, 0}[x^->] [not b]

        // 1) Creating left side of the rule:

        // It is already created (left)

        // 2) Creating right side of the rule:

        // 2.1) Creating name for the right side
        rightName = "stm_" + whileWhile.getId() + "_1";

        // 2.2) Creating arguments for the right side
        rightVars = new ArrayList<>(vars);

        // 2.3) Creating right term
        right = new TRSFunction(rightName, rightVars, WhileType.LIST.getName());

        // 3) Adding new rule
        TRSRule exitWhile = new TRSRule(left, right, new WhileNot(whileWhile.getCondition()).toString());

        // "Looping" the while statement:
        // stm_{}

        // Saving the old left side from the while condition rules:
        TRSTerm oldLeft = left;

        // 1) Creating left side of the rule:

        // 1.1) Creating name for the left side:
        leftName = ((TRSFunction) trs.get(trs.size() - 1).getRight()).getName();

        // 1.2) Creating arguments for the left side:
        leftVars = buildVars();

        // 1.3) Create left term:
        left = new TRSFunction(leftName, leftVars, WhileType.LIST.getName());

        // 2) Creating right side of the rule
        // Already created (oldLeft)
        right = oldLeft;

        // 3) Adding new rule
        trs.add(new TRSRule(left, right));

        // Add rule to exit from While
        trs.add(exitWhile);

        state = new State(stateCopy);
        state.setI(whileWhile.getId());
    }


}
