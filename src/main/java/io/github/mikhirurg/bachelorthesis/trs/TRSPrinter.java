package io.github.mikhirurg.bachelorthesis.trs;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileNot;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print.WhilePrint;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read.WhileRead;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.*;
import org.antlr.v4.runtime.misc.OrderedHashSet;

import java.util.*;

public class TRSPrinter {

    private static class VariableVector {
        private final List<WhileExpression> variables;
        private final Map<WhileVar, Integer> position;

        public VariableVector() {
            this.variables = new ArrayList<>();
            this.position = new HashMap<>();
        }

        public VariableVector(VariableVector other) {
            this.variables = new ArrayList<>(other.variables);
            this.position = new HashMap<>(other.position);
        }

        public void addVariable(WhileVar whileVar) {
            int i = variables.size();
            variables.add(whileVar);
            this.position.put(whileVar, i);
        }

        public List<WhileExpression> substitute(Map<WhileVar, WhileExpression> map) {
            List<WhileExpression> expressions = new ArrayList<>(variables);
            for (WhileVar key : map.keySet()) {
                expressions.set(position.get(key), map.get(key));
            }

            return expressions;
        }

        public List<WhileExpression> getVariables() {
            return variables;
        }
    }

    private static class State {
        private List<TRSRule> rulesList;
        private VariableVector variableVector;
        private int id;

        public State() {
            this.rulesList = new ArrayList<>();
            this.variableVector = new VariableVector();
            this.id = 0;
        }

        public void update(List<TRSRule> rulesSet, VariableVector variableVector, int id) {
            this.rulesList = rulesSet;
            this.variableVector = variableVector;
            this.id = id;
        }

        public List<TRSRule> getRulesList() {
            return rulesList;
        }

        public VariableVector getVariableVector() {
            return variableVector;
        }

        public int getId() {
            return id;
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
    private final State state;

    private final WhileVar IN = new WhileListVar("in");

    private final WhileVar OUT = new WhileListVar("out");

    public TRSPrinter() {
        this.state = new State();
        this.state.variableVector.addVariable(IN);
        this.state.variableVector.addVariable(OUT);
    }

    public List<TRSTerm> convertToTRSTerms(List<WhileExpression> expressions) {
        List<TRSTerm> terms = new ArrayList<>();
        for (WhileExpression expression : expressions) {
            terms.add(new TRSVariable(expression.toString(), expression.getType().getName()));
        }

        return terms;
    }

    public List<TRSRule> getTRSRules() {
        List<TRSRule> rules = new ArrayList<>(state.rulesList);
        List<TRSTerm> leftVars = convertToTRSTerms(state.getVariableVector().variables);

        TRSFunction left = new TRSFunction("stm_" + state.getId(), leftVars, WhileType.LIST.getName());
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

    public void visitSkip(WhileSkip skip) {
        // [[skip]]_{id, x^->} =
        // ({ stm_{id + 1}[x^->] -> stm_{id + 2}[x^->] },
        // x^->,
        // id + 2)

        // Creating TRS rule:
        TRSRule rule = new TRSRule(
                new TRSFunction(
                        "stm_" + (state.getId() + 1),
                        convertToTRSTerms(state.getVariableVector().getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        "stm_" + (state.getId() + 2),
                        convertToTRSTerms(state.getVariableVector().getVariables()),
                        WhileType.LIST.getName()
                )
        );

        // Updating the state:
        state.update(List.of(rule), state.getVariableVector(), state.getId() + 2);
    }

    public void visitDeclaration(WhileVarDeclaration declaration) {
        // [[int x := val_int]]_{id, x^->} =
        // ({ stm_{id + 1}[x^->] -> stm_{id + 2}[x^-> * val_int] [true] },
        // x^-> * val_int,
        // id + 2)

        // Updating variables:
        VariableVector vector = new VariableVector(state.getVariableVector());
        vector.addVariable(declaration.getVariable());

        // Creating TRS rule:
        TRSRule rule = new TRSRule(
                new TRSFunction(
                        "stm_" + (state.getId() + 1),
                        convertToTRSTerms(state.getVariableVector().getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        "stm_" + (state.getId() + 2),
                        convertToTRSTerms(vector.substitute(
                                Map.of(declaration.getVariable(), declaration.getExpression())
                        )),
                        WhileType.LIST.getName()
                )
        );

        // Updating the state:
        state.update(List.of(rule), vector, state.getId() + 2);
    }

    public void visitAssignment(WhileAssignment assignment) {
        // [[x := val_type]]_{id, y^->} =
        // ({ stm_{id + 1}[y^->] -> stm_{id + 2}[y'^->] [true] },
        // y'^->,
        // id + 2)

        // Updating variables:
        List<WhileExpression> expressions = state.getVariableVector().substitute(
                Map.of(assignment.getVariable(), assignment.getExpression()));

        // Creating TRS rule:
        TRSRule rule = new TRSRule(
                new TRSFunction(
                        "stm_" + (state.getId() + 1),
                        convertToTRSTerms(state.getVariableVector().getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        "stm_" + (state.getId() + 2),
                        convertToTRSTerms(expressions),
                        WhileType.LIST.getName()
                )
        );

        // Updating the state:
        state.update(List.of(rule), state.getVariableVector(), state.getId() + 2);
    }

    public void visitPrint(WhilePrint whilePrint) {
        // [[printType(val_type)]]_{id, y^->} =
        // ({ stm_{id + 1}[y^->] -> stm_{id + 2}[y'^->] [true] },
        // y'^->,
        // id + 2)

        // Determining type letter:
        String type = switch (whilePrint.getExpression().getType()) {
            case INT -> "I";
            case BOOL -> "B";
            case STRING -> "S";
            default -> "";
        };

        // Updating variables:
        List<WhileExpression> expressions = state.getVariableVector().substitute(
                Map.of(OUT, new WhileListVar(
                        "cons" + type + "(" +
                                whilePrint.getExpression() + ", " + OUT +
                                ")"))
        );

        // Creating TRS rule:
        TRSRule rule = new TRSRule(
                new TRSFunction(
                        "stm_" + (state.getId() + 1),
                        convertToTRSTerms(state.getVariableVector().getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        "stm_" + (state.getId() + 2),
                        convertToTRSTerms(expressions),
                        WhileType.LIST.getName()
                )
        );

        // Updating the state:
        state.update(List.of(rule), state.getVariableVector(), state.getId() + 2);
    }

    public void visitRead(WhileRead whileRead) {
        // [[x := val_type]]_{id, y^->} =
        // ({ stm_{id + 1}[y^->] -> stm_{id + 2}[y'^->] [true]},
        // y'^->,
        // id + 2)

        // Updating variable, based on the reading type:
        List<WhileExpression> expressions = new ArrayList<>();
        switch (whileRead.getVariable().getType()) {
            case INT -> {
                expressions = state.getVariableVector().substitute(
                        Map.of(
                                IN, new WhileListVar("moveI(" + IN + ")"),
                                whileRead.getVariable(), new WhileIntVar("takeI(" + IN + ")")
                        )
                );
            }
            case BOOL -> {
                expressions = state.getVariableVector().substitute(
                        Map.of(
                                IN, new WhileListVar("moveB(" + IN + ")"),
                                whileRead.getVariable(), new WhileBoolVar("takeB(" + IN + ")")
                        )
                );
            }
            case STRING -> {
                expressions = state.getVariableVector().substitute(
                        Map.of(
                                IN, new WhileListVar("moveS(" + IN + ")"),
                                whileRead.getVariable(), new WhileStringVar("takeI(" + IN + ")")
                        )
                );
            }
        }

        // Creating TRS rule:
        TRSRule rule = new TRSRule(
                new TRSFunction(
                        "stm_" + (state.getId() + 1),
                        convertToTRSTerms(state.getVariableVector().getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        "stm_" + (state.getId() + 2),
                        convertToTRSTerms(expressions),
                        WhileType.LIST.getName()
                )
        );

        // Updating the state:
        state.update(List.of(rule), state.getVariableVector(), state.getId() + 2);
    }

    public void visitComp(WhileComp comp) {
        // [[S1; S2]]_{id, x^->} =
        // (R1 U
        // { stm_{id'}[x^-> * y^->] -> stm_{id' + 1}[x^-> * y^->] [true] } U
        // R2,
        // x^-> * y^->,
        // id'')

        // Explore first statement:
        comp.getStatement1().acceptTRSPrinter(this);

        List<TRSRule> rules1 = new ArrayList<>(state.getRulesList());
        VariableVector vars1 = new VariableVector(state.getVariableVector());
        int id1 = state.getId();

        state.update(new ArrayList<>(), vars1, state.getId());

        // Explore second statement:
        comp.getStatement2().acceptTRSPrinter(this);

        List<TRSRule> rules2 = new ArrayList<>(state.getRulesList());

        // Create the composition of rules:
        List<TRSRule> compRulesList = new ArrayList<>(rules1);
        compRulesList.add(new TRSRule(
                new TRSFunction(
                        "stm_" + id1,
                        convertToTRSTerms(vars1.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        "stm_" + (id1 + 1),
                        convertToTRSTerms(vars1.getVariables()),
                        WhileType.LIST.getName()
                )
        ));
        compRulesList.addAll(rules2);

        // Updating the state:
        state.update(compRulesList, state.getVariableVector(), state.getId());
    }

    public void visitIf(WhileIf whileIf) {
        // [[if b then S1 else S2]]_{id, x^->} =
        // ({ stm_{id + 1}[x^->] -> stm_{id + 2}[x^->] [b] } U
        // R1 U
        // { stm_{id + 1}[x^->] -> stm_{id' + 1}[x^->] [neg(b)] } U
        // R2 U
        // { stm_{id'}[x^-> * y^->] -> stm_{id'' + 1}[x^->] [true] } U
        // { stm_{id''}[x^-> * z^->] -> stm_{id'' + 1}[x^->] [true] },
        // x^->,
        // id'' + 1)

        VariableVector oldVector = new VariableVector(state.getVariableVector());
        int id = state.getId();

        state.update(state.getRulesList(), state.getVariableVector(), state.getId() + 1);

        whileIf.getStatement1().acceptTRSPrinter(this);

        List<TRSRule> rules1 = new ArrayList<>(state.getRulesList());
        VariableVector vector1 = new VariableVector(state.getVariableVector());
        int id1 = state.getId();

        state.update(new ArrayList<>(), oldVector, state.getId());

        whileIf.getStatement2().acceptTRSPrinter(this);

        List<TRSRule> rules2 = new ArrayList<>(state.getRulesList());
        VariableVector vector2 = new VariableVector(state.getVariableVector());
        int id2 = state.getId();

        List<TRSRule> ifRulesList = new ArrayList<>();
        // { stm_{id + 1}[x^->] -> stm_{id + 2}[x^->] [b] }
        ifRulesList.add(new TRSRule(
                new TRSFunction("stm_" + (id + 1),
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction("stm_" + (id + 2),
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                whileIf.getCondition().toString()
        ));
        // R1
        ifRulesList.addAll(rules1);
        // { stm_{id + 1}[x^->] -> stm_{id' + 1}[x^->] [neg(b)] }
        ifRulesList.add(new TRSRule(
                new TRSFunction("stm_" + (id + 1),
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction("stm_" + (id1 + 1),
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                new WhileNot(whileIf.getCondition()).toString()
        ));
        // R2
        ifRulesList.addAll(rules2);
        // { stm_{id'}[x^-> * y^->] -> stm_{id'' + 1}[x^->] [true] }
        ifRulesList.add(new TRSRule(
                new TRSFunction("stm_" + id1,
                        convertToTRSTerms(vector1.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction("stm_" + (id2 + 1),
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                )
        ));
        // { stm_{id''}[x^-> * z^->] -> stm_{id'' + 1}[x^->] [true] }
        ifRulesList.add(new TRSRule(
                new TRSFunction("stm_" + id2,
                        convertToTRSTerms(vector2.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction("stm_" + (id2 + 1),
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                )
        ));

        // Updating the state:
        state.update(ifRulesList, oldVector, id2 + 1);
    }


    public void visitWhile(WhileWhile whileWhile) {
        // [[while b do S]]_{id, x^->} =
        // ({ stm_{id + 1}[x^->] -> stm_{id + 2}[x^->] [b] } U
        // R1 U
        // { stm_{id'}[x^-> * y^->] -> stm_{id + 1}[x^->] [true] } U
        // { stm_{id + 1}[x^->] -> stm_{id' + 1}[x^->] [not(b)] },
        // x^->,
        // id' + 1)

        VariableVector oldVector = new VariableVector(state.getVariableVector());
        int id = state.getId();

        state.update(state.getRulesList(), state.getVariableVector(), state.getId() + 1);

        whileWhile.getStatement().acceptTRSPrinter(this);

        List<TRSRule> rules1 = state.getRulesList();
        VariableVector vector1 = state.getVariableVector();
        int id1 = state.getId();

        List<TRSRule> whileRulesList = new ArrayList<>();
        // { stm_{id + 1}[x^->] -> stm_{id + 2}[x^->] [b] }
        whileRulesList.add(new TRSRule(
                new TRSFunction(
                        "stm_" + (id + 1),
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        "stm_" + (id + 2),
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                whileWhile.getCondition().toString()
        ));
        // R1
        whileRulesList.addAll(rules1);
        // { stm_{id'}[x^-> * y^->] -> stm_{id + 1}[x^->] [true] }
        whileRulesList.add(new TRSRule(
                new TRSFunction(
                        "stm_" + id1,
                        convertToTRSTerms(vector1.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        "stm_" + (id + 1),
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                )
        ));
        // { stm_{id + 1}[x^->] -> stm_{id' + 1}[x^->] [not(b)] }
        whileRulesList.add(new TRSRule(
                new TRSFunction(
                        "stm_" + (id + 1),
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        "stm_" + (id1 + 1),
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                new WhileNot(whileWhile.getCondition()).toString()
        ));

        // Updating the state:
        state.update(whileRulesList, oldVector, id1 + 1);
    }
}
