package io.github.mikhirurg.bachelorthesis.trs;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileNot;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print.WhilePrint;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read.WhileRead;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.*;
import org.antlr.v4.runtime.misc.OrderedHashSet;

import java.util.*;

/**
 * TRSPrinter is a class that represents the implementation of the translation function,
 * that allows translating arbitrary While++ programs into the LCTRS.
 */
public class TRSPrinter {

    /**
     * VariableVector is a class that represents the vector of variables
     * that exist in the environment in the moment of execution of the certain program statement.
     */
    private static class VariableVector {

        /**
         * The list of While++ variables.
         */
        private final List<WhileExpression> variables;

        /**
         * The map that represent the position of each variable from the variable vector in the LCTRS function symbol.
         */
        private final Map<WhileVar, Integer> position;

        /**
         * VariableVector constructor.
         */
        public VariableVector() {
            this.variables = new ArrayList<>();
            this.position = new HashMap<>();
        }

        /**
         * VariableVector copy constructor.
         * @param other another VariableVector instance
         */
        public VariableVector(VariableVector other) {
            this.variables = new ArrayList<>(other.variables);
            this.position = new HashMap<>(other.position);
        }

        /**
         * The method adds the While++ variable to the current variable vector
         * @param whileVar the While++ variable
         */
        public void addVariable(WhileVar whileVar) {
            int i = variables.size();
            variables.add(whileVar);
            this.position.put(whileVar, i);
        }

        /**
         * The method returns the <code>map</code> substitution application to the copy of the list of While++ variables.
         * @param map the substitution from While++ variables to the While++ expressions
         *            (could be an expression or variable of an appropriate type)
         * @return the list of While++ variables and expressions after application of the substitution <code>map</code>
         */
        public List<WhileExpression> substitute(Map<WhileVar, WhileExpression> map) {
            List<WhileExpression> expressions = new ArrayList<>(variables);
            for (WhileVar key : map.keySet()) {
                expressions.set(position.get(key), map.get(key));
            }

            return expressions;
        }

        /**
         * The method returns the list of the While++ variables.
         * @return the list of the While++ variables
         */
        public List<WhileExpression> getVariables() {
            return variables;
        }
    }

    /**
     * State is a class thar represents the current state of the translation function.
     * It keeps track of the generated LCTRS rules and the variables that exists in the environment
     * at the moment of the translation function application.
     */
    private static class State {

        /**
         * The current list of generated LCTRS rules.
         */
        private List<TRSRule> rulesList;

        /**
         * The current list of the While++ variables that exist in the environment.
         */
        private VariableVector variableVector;

        /**
         * The last used identifier value for the LCTRS term.
         */
        private int id;

        /**
         * State constructor.
         */
        public State() {
            this.rulesList = new ArrayList<>();
            this.variableVector = new VariableVector();
            this.id = 0;
        }

        /**
         * The method allows updating the state by providing the new set of LCTRS rules, new vector of variables,
         * and the new value of the last used LCTRS term identifier.
         * @param rulesSet the new set of LCTRS rules
         * @param variableVector the new vector of While++ variables
         * @param id the new value of the last used LCTRS term id
         */
        public void update(List<TRSRule> rulesSet, VariableVector variableVector, int id) {
            this.rulesList = rulesSet;
            this.variableVector = variableVector;
            this.id = id;
        }

        /**
         * The method returns the current list of generated LCTRS rules.
         * @return the current list of generated LCTRS rules
         */
        public List<TRSRule> getRulesList() {
            return rulesList;
        }

        /**
         * The method returns the current vector of While++ variables.
         * @return the current vector of While++ variables
         */
        public VariableVector getVariableVector() {
            return variableVector;
        }

        /**
         * The method returns the value of the last used LCTRS term id
         * @return the last used LCTRS term id
         */
        public int getId() {
            return id;
        }
    }

    /**
     * The basic rules that represent operations with the I/O lists.
     */
    private final static String LIST_RULES =
            """
                    nil :: list
                    consI :: Int -> list -> list
                    consB :: Bool -> list -> list
                    consS :: String -> list -> list
                                
                    headI :: list -> Int
                    headB :: list -> Bool
                    headS :: list -> String
                                
                    tailI :: list -> list
                    tailB :: list -> list
                    tailS :: list -> list

                    headI(consI(i, l)) -> i
                    headB(consB(b, l)) -> b
                    headS(consS(str, l)) -> str

                    tailI(consI(i, l)) -> l
                    tailB(consB(b, l)) -> l
                    tailS(consS(str, l)) -> l
                                
                    """;

    /**
     * The translation function state.
     */
    private final State state;

    /**
     * The variable that represents the standard input list.
     */
    private final WhileVar IN = new WhileListVar("in");

    /**
     * The variable that represents the standard output list.
     */
    private final WhileVar OUT = new WhileListVar("out");

    /**
     * TRSPrinter constructor.
     */
    public TRSPrinter() {
        this.state = new State();
        this.state.variableVector.addVariable(IN);
        this.state.variableVector.addVariable(OUT);
    }

    /**
     * The method that converts the list of While++ variables and expressions into the list of LCTRS terms
     * @param expressions the list of While++ variables and expressions
     * @return the list of LCTRS terms
     */
    public List<TRSTerm> convertToTRSTerms(List<WhileExpression> expressions) {
        List<TRSTerm> terms = new ArrayList<>();
        for (WhileExpression expression : expressions) {
            terms.add(new TRSVariable(expression.toString(), expression.getType().getName()));
        }

        return terms;
    }

    /**
     * The method returns the LCTRS rules generated by the translation function.
     * It is required to call the <code>acceptTRSPrinter</code> method for the target While++ program class representation
     * to get a reasonable output.
     * @return the list of generated LCTRS rules
     */
    public List<TRSRule> getTRSRules() {
        List<TRSRule> rules = new ArrayList<>(state.rulesList);
        List<TRSTerm> leftVars = convertToTRSTerms(state.getVariableVector().variables);

        TRSFunction left = new TRSFunction(STR."stm_\{state.getId()}", leftVars, WhileType.LIST.getName());
        TRSVariable right = new TRSVariable("out", WhileType.LIST.getName());

        rules.add(new TRSRule(left, right));
        return rules;
    }

    /**
     * The method returns the LCTRS rules text representation including the type declarations for all function symbols.
     * This text representation is compatible with the Cora (COnstrained Rewriting Analyzer).
     * It is required to call the <code>acceptTRSPrinter</code> method for the target While++ program class representation
     * to get a reasonable output.
     * @return the text representation of the LCTRS translation for the While++ program.
     */
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

    /**
     * The visit method for the While++ "skip" statement.
     * Generates the LCTRS translation of the "skip" statement.
     * @param skip the While++ "skip" statement class representation
     */
    public void visitSkip(WhileSkip skip) {
        // [[skip]]_{id, x^->} =
        // ({ stm_{id + 1}[x^->] -> stm_{id + 2}[x^->] },
        // x^->,
        // id + 2)

        // Creating TRS rule:
        TRSRule rule = new TRSRule(
                new TRSFunction(
                        STR."stm_\{state.getId() + 1}",
                        convertToTRSTerms(state.getVariableVector().getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        STR."stm_\{state.getId() + 2}",
                        convertToTRSTerms(state.getVariableVector().getVariables()),
                        WhileType.LIST.getName()
                )
        );

        // Updating the state:
        state.update(List.of(rule), state.getVariableVector(), state.getId() + 2);
    }

    /**
     * The visit method for the While++ variable declaration statement.
     * Generates the LCTRS translation of the variable declaration statement.
     * @param declaration the While++ variable declaration statement class representation
     */
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
                        STR."stm_\{state.getId() + 1}",
                        convertToTRSTerms(state.getVariableVector().getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        STR."stm_\{state.getId() + 2}",
                        convertToTRSTerms(vector.substitute(
                                Map.of(declaration.getVariable(), declaration.getExpression())
                        )),
                        WhileType.LIST.getName()
                )
        );

        // Updating the state:
        state.update(List.of(rule), vector, state.getId() + 2);
    }

    /**
     * The visit method for the While++ variable assignment statement.
     * Generates the LCTRS translation of the variable assignment.
     * @param assignment the While++ variable assignment statement class representation
     */
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
                        STR."stm_\{state.getId() + 1}",
                        convertToTRSTerms(state.getVariableVector().getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        STR."stm_\{state.getId() + 2}",
                        convertToTRSTerms(expressions),
                        WhileType.LIST.getName()
                )
        );

        // Updating the state:
        state.update(List.of(rule), state.getVariableVector(), state.getId() + 2);
    }

    /**
     * The visit method for the While++ "print" statements.
     * Generates the LCTRS translation of the "print" statements.
     * @param whilePrint the While++ "print" statement class representation
     */
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
                Map.of(OUT, new WhileListVar(STR."cons\{type}(\{whilePrint.getExpression()}, \{OUT})"))
        );

        // Creating TRS rule:
        TRSRule rule = new TRSRule(
                new TRSFunction(
                        STR."stm_\{state.getId() + 1}",
                        convertToTRSTerms(state.getVariableVector().getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        STR."stm_\{state.getId() + 2}",
                        convertToTRSTerms(expressions),
                        WhileType.LIST.getName()
                )
        );

        // Updating the state:
        state.update(List.of(rule), state.getVariableVector(), state.getId() + 2);
    }

    /**
     * The visit method for the While++ "read" statements.
     * Generates the LCTRS translation of the "read" statements.
     * @param whileRead the While++ "read" statement class representation
     */
    public void visitRead(WhileRead whileRead) {
        // [[x := val_type]]_{id, y^->} =
        // ({ stm_{id + 1}[y^->] -> stm_{id + 2}[y'^->] [true]},
        // y'^->,
        // id + 2)

        // Updating variable, based on the reading type:
        List<WhileExpression> expressions = new ArrayList<>();
        switch (whileRead.getVariable().getType()) {
            case INT -> expressions = state.getVariableVector().substitute(
                    Map.of(
                            IN, new WhileListVar(STR."tailI(\{IN})"),
                            whileRead.getVariable(), new WhileIntVar(STR."headI(\{IN})")
                    )
            );
            case BOOL -> expressions = state.getVariableVector().substitute(
                    Map.of(
                            IN, new WhileListVar(STR."tailB(\{IN})"),
                            whileRead.getVariable(), new WhileBoolVar(STR."headB(\{IN})")
                    )
            );
            case STRING -> expressions = state.getVariableVector().substitute(
                    Map.of(
                            IN, new WhileListVar(STR."tailS(\{IN})"),
                            whileRead.getVariable(), new WhileStringVar(STR."headS(\{IN})")
                    )
            );
        }

        // Creating TRS rule:
        TRSRule rule = new TRSRule(
                new TRSFunction(
                        STR."stm_\{state.getId() + 1}",
                        convertToTRSTerms(state.getVariableVector().getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        STR."stm_\{state.getId() + 2}",
                        convertToTRSTerms(expressions),
                        WhileType.LIST.getName()
                )
        );

        // Updating the state:
        state.update(List.of(rule), state.getVariableVector(), state.getId() + 2);
    }

    /**
     * The visit method for the While++ composition of statements.
     * Generates the LCTRS translation of the statement composition.
     * @param comp the While++ statement composition class representation
     */
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
                        STR."stm_\{id1}",
                        convertToTRSTerms(vars1.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        STR."stm_\{id1 + 1}",
                        convertToTRSTerms(vars1.getVariables()),
                        WhileType.LIST.getName()
                )
        ));
        compRulesList.addAll(rules2);

        // Updating the state:
        state.update(compRulesList, state.getVariableVector(), state.getId());
    }

    /**
     * The visit method for the While++ "if" statement.
     * Generates the LCTRS translation of the "if" statement.
     * @param whileIf the While++ "if" statement class representation
     */
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
                new TRSFunction(STR."stm_\{id + 1}",
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(STR."stm_\{id + 2}",
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                whileIf.getCondition().toString()
        ));
        // R1
        ifRulesList.addAll(rules1);
        // { stm_{id + 1}[x^->] -> stm_{id' + 1}[x^->] [neg(b)] }
        ifRulesList.add(new TRSRule(
                new TRSFunction(STR."stm_\{id + 1}",
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(STR."stm_\{id1 + 1}",
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                new WhileNot(whileIf.getCondition()).toString()
        ));
        // R2
        ifRulesList.addAll(rules2);
        // { stm_{id'}[x^-> * y^->] -> stm_{id'' + 1}[x^->] [true] }
        ifRulesList.add(new TRSRule(
                new TRSFunction(STR."stm_\{id1}",
                        convertToTRSTerms(vector1.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(STR."stm_\{id2 + 1}",
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                )
        ));
        // { stm_{id''}[x^-> * z^->] -> stm_{id'' + 1}[x^->] [true] }
        ifRulesList.add(new TRSRule(
                new TRSFunction(STR."stm_\{id2}",
                        convertToTRSTerms(vector2.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(STR."stm_\{id2 + 1}",
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                )
        ));

        // Updating the state:
        state.update(ifRulesList, oldVector, id2 + 1);
    }

    /**
     * The visit method for the While++ "while" loop statement.
     * Generates the LCTRS translation of the "while" loop.
     * @param whileWhile the While++ "while" loop statement class representation
     */
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
                        STR."stm_\{id + 1}",
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        STR."stm_\{id + 2}",
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
                        STR."stm_\{id1}",
                        convertToTRSTerms(vector1.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        STR."stm_\{id + 1}",
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                )
        ));
        // { stm_{id + 1}[x^->] -> stm_{id' + 1}[x^->] [not(b)] }
        whileRulesList.add(new TRSRule(
                new TRSFunction(
                        STR."stm_\{id + 1}",
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                new TRSFunction(
                        STR."stm_\{id1 + 1}",
                        convertToTRSTerms(oldVector.getVariables()),
                        WhileType.LIST.getName()
                ),
                new WhileNot(whileWhile.getCondition()).toString()
        ));

        // Updating the state:
        state.update(whileRulesList, oldVector, id1 + 1);
    }
}
