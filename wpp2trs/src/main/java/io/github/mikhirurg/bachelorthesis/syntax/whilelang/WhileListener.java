package io.github.mikhirurg.bachelorthesis.syntax.whilelang;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.gen.WhileBaseListener;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.gen.WhileParser;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print.WhilePrintBool;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print.WhilePrintInt;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print.WhilePrintString;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read.WhileReadBool;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read.WhileReadInt;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read.WhileReadString;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileString;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileStringExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * WhileListener is the ParseTreeListener used to process the While++ parse tree
 * It allows to generate the class representation of the While++ program
 */
public class WhileListener extends WhileBaseListener {

    /**
     * Stack used for constructing arithmetic expressions
     */
    private final Stack<WhileArithmeticExpression> arithmeticStack;

    /**
     * Stack used for constructing boolean expressions
     */
    private final Stack<WhileBooleanExpression> booleanStack;

    /**
     * Stack used for constructing string expressions
     */
    private final Stack<WhileStringExpression> stringsStack;

    /**
     * Stack used for constructing the program class representation from the representations of sub-statements
     */
    private final Stack<WhileStatement> statementStack;

    /**
     * Map of currently active While++ variables
     */
    private HashMap<String, WhileVar> variables;

    /**
     * Map of variables, used to clean the scope of declared variables
     * (for example after leaving the body of <code>while</code> or <code>if</code>)
     */
    private HashMap<String, WhileVar> tmpVariables;

    /**
     * Pattern for recognizing the variables in the parse tree
     */
    private static final Pattern VAR_PATTERN = Pattern.compile("[a-zA-Z]+");

    /**
     * Pattern for recognizing the numbers in the parse tree
     */
    private static final Pattern INT_PATTERN = Pattern.compile("[0-9]+");

    /**
     * Pattern for recognizing strings in the parse tree
     */
    private static final Pattern STRING_PATTERN = Pattern.compile("\"(.*)\"");

    /**
     * Keyword for logical NOT
     */
    private static final String NOT = "not";

    /**
     * Keyword for logical AND
     */
    private static final String AND = "and";

    /**
     * Keyword for logical OR
     */
    private static final String OR = "or";

    /**
     * Keyword for "equals" operator
     */
    private static final String EQ = "=";

    /**
     * Keyword for "greater than" operator
     */
    private static final String GT = ">";

    /**
     * Keyword for "less than" operator
     */
    private static final String LT = "<";

    /**
     * Keyword for "greater than or equals to" operator
     */
    private static final String GE = ">=";

    /**
     * Keyword for "less than or equals to" operator
     */
    private static final String LE = "<=";

    /**
     * Keyword for statement composition operator
     */
    private static final String SEMICOLON = ";";

    /**
     * Keyword for integer type (used in variable declaration)
     */
    private static final String INT_TYPE = "int";

    /**
     * Keyword for boolean type (used in variable declaration)
     */
    private static final String BOOL_TYPE = "bool";

    /**
     * Keyword for string type (used in variable declaration)
     */
    private static final String STRING_TYPE = "string";

    /**
     * Keyword for addition operator (arithmetic expressions)
     */
    private static final String PLUS = "+";

    /**
     * Keyword for subtraction operator (arithmetic expression)
     */
    private static final String MINUS = "-";

    /**
     * Keyword for multiplication operator (arithmetic expression)
     */
    private static final String MULT = "*";

    /**
     * Keyword for division operator (arithmetic expression)
     */
    private static final String DIV = "/";

    /**
     * Keyword for modulo operator (arithmetic expression)
     */
    private static final String MOD = "%";

    /**
     * Keyword for "true" boolean constant
     */
    private static final String TRUE = "true";

    /**
     * Keyword for "false" boolean constant
     */
    private static final String FALSE = "false";

    /**
     * While++ program class representation
     */
    private WhileStatement program;

    /**
     * Default constructor for the WhileListener
     */
    public WhileListener() {
        this.arithmeticStack = new Stack<>();
        this.booleanStack = new Stack<>();
        this.statementStack = new Stack<>();
        this.variables = new HashMap<>();
        this.tmpVariables = new HashMap<>();
        this.stringsStack = new Stack<>();
    }

    /**
     * The method returns currently non-empty stacks:
     * <ul>
     *     <li> string expressions stack,
     *     <li> boolean expressions stack,
     *     <li> arithmetic expressions stack
     * </ul>
     * @return set of currently non-empty expressions stack
     */
    private Set<WhileType> getNonEmptyStacks() {
        Set<WhileType> types = new HashSet<>();
        if (!stringsStack.isEmpty()) {
            types.add(WhileType.STRING);
        }
        if (!booleanStack.isEmpty()) {
            types.add(WhileType.BOOL);
        }
        if (!arithmeticStack.isEmpty()) {
            types.add(WhileType.INT);
        }

        return types;
    }

    /**
     * The method that adds the variable to the correct expression stack based on the type of the variable
     * @param var variable, which is added to any of the expression's stacks
     */
    private void processVariable(WhileVar var) {
        if (var.getType() == WhileType.INT) {
            arithmeticStack.add((WhileIntVar) var);
        } else if (var.getType() == WhileType.BOOL) {
            booleanStack.add((WhileBoolVar) var);
        } else if (var.getType() == WhileType.STRING) {
            stringsStack.add((WhileStringVar) var);
        }
    }

    /**
     * The method returns the build class representation of the program.
     * To get the output program, it is required to perform the walk in AST using this listener, before calling this method.
     * @return class representation of the program
     */
    public WhileStatement getProgram() {
        return program;
    }

    /**
     * The method saves the variables currently existing in the environment
     * before entering the body of the <code>if</code> statement
     * @param ctx the parse tree
     */
    @Override
    public void enterIfStm(WhileParser.IfStmContext ctx) {
        super.enterIfStm(ctx);

        tmpVariables = new HashMap<>(variables);
    }

    /**
     * The method saves the variables currently declared in the environment
     * before entering the body of the <code>while</code> statement
     * @param ctx the parse tree
     */
    @Override
    public void enterWhileStm(WhileParser.WhileStmContext ctx) {
        super.enterWhileStm(ctx);

        tmpVariables = new HashMap<>(variables);
    }

    /**
     * The method takes the build program class representation from the program statement stack
     * and assigns it to the <code>program</code> variable
     * @param ctx the parse tree
     */
    @Override
    public void exitProg(WhileParser.ProgContext ctx) {
        super.exitProg(ctx);

        this.program = statementStack.pop();
    }

    /**
     * The method constructs the statement composition class representation
     * by taking the first and second sub-statements representation from the statements stack,
     * wrapping it with WhileComp class, and putting it back to the statements stack.
     * @param ctx the parse tree
     * @throws ExpectedStatementException if the parse tree missing the sub-statement
     * (for example in case of statement composition: <code>S1;S2</code> and S2 is missing)
     */
    @Override
    public void exitStm(WhileParser.StmContext ctx) {
        super.exitStm(ctx);

        if (ctx.children == null || ctx.children.isEmpty()) {
            throw new ExpectedStatementException(ctx);
        }

        if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(SEMICOLON)) {
            WhileStatement s2 = statementStack.pop();
            WhileStatement s1 = statementStack.pop();
            statementStack.add(new WhileComp(s1, s2));
        }
    }

    /**
     * The method constructs the variable assignment statement class representation
     * and adds it to the statements stack.
     * @param ctx the parse tree
     * @throws VariableNotDeclaredException if the variable used in the assignment was not yet declared
     */
    @Override
    public void exitAssignStm(WhileParser.AssignStmContext ctx) {
        super.exitAssignStm(ctx);

        String varName = ctx.children.getFirst().getText();

        if (variables.containsKey(varName)) {
            WhileVar variable = variables.get(varName);
            switch (variable.getType()) {
                case STRING -> {
                    WhileStringExpression stringExpression = stringsStack.pop();
                    statementStack.add(new WhileAssignment(variable, stringExpression));
                }
                case BOOL -> {
                    WhileBooleanExpression booleanExpression = booleanStack.pop();
                    statementStack.add(new WhileAssignment(variable, booleanExpression));
                }
                case INT -> {
                    WhileArithmeticExpression arithmeticExpression = arithmeticStack.pop();
                    statementStack.add(new WhileAssignment(variable, arithmeticExpression));
                }
                default -> {

                }
            }
        } else {
            throw new VariableNotDeclaredException(ctx, varName);
        }
    }

    /**
     * The method constructs the variable declaration class representation and adds it to the statements stack.
     * @param ctx the parse tree
     *
     * @throws DuplicateVariableDeclarationException
     * if this variable was already declared before in the same area of visibility.
     *
     * @throws IncompatibleTypeException if the type of the expression assigned to the variable
     * is incompatible with the variable type
     */
    @Override
    public void exitDeclareStm(WhileParser.DeclareStmContext ctx) {
        super.exitDeclareStm(ctx);

        String varName = ctx.children.get(1).getText();

        WhileType varType = switch (ctx.children.get(0).getText()) {
            case BOOL_TYPE -> WhileType.BOOL;
            case STRING_TYPE -> WhileType.STRING;
            default -> WhileType.INT;
        };

        WhileVar variable;
        if (variables.containsKey(varName)) {
            throw new DuplicateVariableDeclarationException(ctx, variables.get(varName));
        } else {
            switch (varType) {
                case STRING -> {
                    variable = new WhileStringVar(varName);
                    if (getNonEmptyStacks().contains(varType)) {
                        statementStack.add(new WhileVarDeclaration(variable, stringsStack.pop()));
                    } else {
                        throw new IncompatibleTypeException(ctx, variable, varType);
                    }
                }
                case BOOL -> {
                    variable = new WhileBoolVar(varName);
                    if (getNonEmptyStacks().contains(varType)) {
                        statementStack.add(new WhileVarDeclaration(variable, booleanStack.pop()));
                    } else {
                        throw new IncompatibleTypeException(ctx, variable, varType);
                    }
                }
                default -> {
                    variable = new WhileIntVar(varName);
                    if (getNonEmptyStacks().contains(varType)) {
                        statementStack.add(new WhileVarDeclaration(variable, arithmeticStack.pop()));
                    } else {
                        throw new IncompatibleTypeException(ctx, variable, varType);
                    }
                }
            }

            variables.put(varName, variable);
        }
    }

    /**
     * The method constructs the if statement class representation and adds it to the statements stack.
     * @param ctx the parse tree
     */
    @Override
    public void exitIfStm(WhileParser.IfStmContext ctx) {
        super.exitIfStm(ctx);

        WhileBooleanExpression expression = booleanStack.pop();
        WhileStatement s2 = statementStack.pop();
        WhileStatement s1 = statementStack.pop();
        statementStack.add(new WhileIf(expression, s1, s2));
    }

    /**
     * The method clears the map of declared variables after leaving the if statement or the while loop
     * from the variables which were declared in the body of the while or inside if.
     * @param ctx the parse tree
     */
    @Override
    public void exitNestedStm(WhileParser.NestedStmContext ctx) {
        super.exitNestedStm(ctx);
        variables = new HashMap<>(tmpVariables);
    }

    /**
     * The method creates the class representation of the boolean expression printing statement
     * and adds it to the statements stack.
     * @param ctx the parse tree
     * @throws ExpectedTypeException if the expression of the wrong type is passed into the body of the print statement
     * (not a boolean expression)
     */
    @Override
    public void exitPrintBoolStm(WhileParser.PrintBoolStmContext ctx) {
        super.exitPrintBoolStm(ctx);

        if (!booleanStack.isEmpty()) {
            statementStack.add(new WhilePrintBool(booleanStack.pop()));
        } else {
            throw new ExpectedTypeException(ctx, WhileType.BOOL);
        }
    }

    /**
     * The method creates the class representation of the arithmetic expression printing statement
     * and adds it to the statements stack.
     * @param ctx the parse tree
     * @throws ExpectedTypeException if the expression of the wrong type is passed into the body of the print statement
     * (not an arithmetic expression)
     */
    @Override
    public void exitPrintIntStm(WhileParser.PrintIntStmContext ctx) {
        super.exitPrintIntStm(ctx);

        if (!arithmeticStack.isEmpty()) {
            statementStack.add(new WhilePrintInt(arithmeticStack.pop()));
        } else {
            throw new ExpectedTypeException(ctx, WhileType.INT);
        }
    }

    /**
     * The method creates the class representation of the string expression printing statement
     * and adds it to the statements stack
     * @param ctx the parse tree
     * @throws ExpectedTypeException if the expression of the wrong type is passed into the body of the print statement
     * (not a string expression)
     */
    @Override
    public void exitPrintStringStm(WhileParser.PrintStringStmContext ctx) {
        super.exitPrintStringStm(ctx);

        if (!stringsStack.isEmpty()) {
            statementStack.add(new WhilePrintString(stringsStack.pop()));
        } else {
            throw new ExpectedTypeException(ctx, WhileType.STRING);
        }
    }

    /**
     * The method creates the class representation of reading statement for boolean variable
     * and adds it to the statements stack.
     * @param ctx the parse tree
     * @throws ExpectedTypeException if the variable of the wrong type is used (not a boolean variable)
     */
    @Override
    public void exitReadBoolStm(WhileParser.ReadBoolStmContext ctx) {
        super.exitReadBoolStm(ctx);

        String varName = ctx.children.get(2).getText();
        if (variables.containsKey(varName)) {
            statementStack.add(new WhileReadBool((WhileBoolVar) variables.get(varName)));
        } else {
            throw new ExpectedTypeException(ctx, WhileType.BOOL);
        }
    }

    /**
     * The method creates the class representation of the reading statement for the integer variable
     * and adds it to the statements stack.
     * @param ctx the parse tree
     * @throws ExpectedTypeException if the variable of the wrong type is used (not an integer variable)
     */
    @Override
    public void exitReadIntStm(WhileParser.ReadIntStmContext ctx) {
        super.exitReadIntStm(ctx);

        String varName = ctx.children.get(2).getText();
        if (variables.containsKey(varName)) {
            statementStack.add(new WhileReadInt((WhileIntVar) variables.get(varName)));
        } else {
            throw new ExpectedTypeException(ctx, WhileType.INT);
        }
    }

    /**
     * The method creates the class representation of the reading statement for the string variable
     * and adds it to the statements stack.
     * @param ctx the parse tree
     * @throws ExpectedTypeException if the variable of the wrong type is used (not a string variable)
     */
    @Override
    public void exitReadStringStm(WhileParser.ReadStringStmContext ctx) {
        super.exitReadStringStm(ctx);

        String varName = ctx.children.get(2).getText();
        if (variables.containsKey(varName)) {
            statementStack.add(new WhileReadString((WhileStringVar) variables.get(varName)));
        } else {
            throw new ExpectedTypeException(ctx, WhileType.STRING);
        }
    }

    /**
     * The method creates the class representation of the "skip" statement and adds it to the statements stack.
     * @param ctx the parse tree
     */
    @Override
    public void exitSkipStm(WhileParser.SkipStmContext ctx) {
        super.exitSkipStm(ctx);

        statementStack.add(new WhileSkip());
    }

    /**
     * The method creates the class representation of the "while" statement and adds it to the statements stack.
     * @param ctx the parse tree
     */
    @Override
    public void exitWhileStm(WhileParser.WhileStmContext ctx) {
        super.exitWhileStm(ctx);

        variables = new HashMap<>(tmpVariables);
        WhileBooleanExpression expression = booleanStack.pop();
        WhileStatement statement = statementStack.pop();
        statementStack.add(new WhileWhile(expression, statement));
    }

    /**
     * The method processes the variable used in assignment/declaration statement
     * and adds it to the correct expression stack
     * @param ctx the parse tree
     */
    @Override
    public void exitUntypedexpr(WhileParser.UntypedexprContext ctx) {
        super.exitUntypedexpr(ctx);
        String varName = ctx.children.getFirst().getText();
        if (variables.containsKey(varName)) {
            WhileVar var = variables.get(varName);
            processVariable(var);
        }
    }

    /**
     * The method creates the class representation of the binary arithmetic operation:
     * <ul>
     *     <li> multiplication
     *     <li> division
     *     <li> modulo operation
     *     <li> addition
     *     <li> subtraction
     * </ul>
     * And it adds this class representation to the arithmetic expressions stack
     * @param ctx the parse tree
     */
    @Override
    public void exitAexp(WhileParser.AexpContext ctx) {
        super.exitAexp(ctx);
        if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(MULT)) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            arithmeticStack.add(new WhileMult(left, right));
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(DIV)) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            arithmeticStack.add(new WhileDiv(left, right));
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(MOD)) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            arithmeticStack.add(new WhileMod(left, right));
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(PLUS)) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            arithmeticStack.add(new WhilePlus(left, right));
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(MINUS)) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            arithmeticStack.add(new WhileSub(left, right));
        }
    }

    /**
     * The method creates the class representation of the integers and the integer variables
     * and adds it to the arithmetic expressions stack.
     * @param ctx the parse tree
     * @throws VariableNotDeclaredException if the encountered variable was not yet declared in the program
     */
    @Override
    public void exitAexpatom(WhileParser.AexpatomContext ctx) {
        super.exitAexpatom(ctx);

        if (ctx.children.size() == 1) {
            if (VAR_PATTERN.matcher(ctx.children.getFirst().getText()).matches()) {
                String varName = ctx.children.getFirst().getText();
                if (variables.containsKey(varName)) {
                    WhileVar var = variables.get(varName);
                    if (!var.getType().equals(WhileType.INT)) {
                        throw new IncompatibleTypeException(ctx, var, WhileType.INT);
                    }
                    arithmeticStack.add((WhileIntVar) var);
                } else {
                    throw new VariableNotDeclaredException(ctx, varName);
                }

            } else if (INT_PATTERN.matcher(ctx.children.getFirst().getText()).matches()) {
                arithmeticStack.add(new WhileConst(ctx.children.getFirst().getText()));
            }
        }
    }

    /**
     * The method creates the class representation of the boolean constants (true/false) and boolean variables
     * and adds it to the boolean expressions stack.
     * @param ctx the parse tree
     * @throws VariableNotDeclaredException if the encountered variable was not yet declared in the program
     */
    @Override
    public void exitBexpatom(WhileParser.BexpatomContext ctx) {
        super.exitBexpatom(ctx);

        if (ctx.children.size() == 1) {
            if (ctx.children.getFirst().getText().equals(TRUE)) {
                booleanStack.add(new WhileTrueConst());
            } else if (ctx.children.getFirst().getText().equals(FALSE)) {
                booleanStack.add(new WhileFalseConst());
            } else if (VAR_PATTERN.matcher(ctx.children.getFirst().getText()).matches()) {
                String varName = ctx.children.getFirst().getText();
                if (variables.containsKey(varName)) {
                    WhileVar var = variables.get(varName);
                    processVariable(var);
                } else {
                    throw new VariableNotDeclaredException(ctx, varName);
                }
            }
        }
    }

    /**
     * The method creates the class representation of the operators with the resulting boolean type
     * and adds it to the boolean expressions stack.
     * @param ctx the parse tree
     */
    @Override
    public void exitBexp(WhileParser.BexpContext ctx) {
        super.exitBexp(ctx);
        if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(EQ)) {

            Set<WhileType> types = getNonEmptyStacks();

            for (WhileType type : types) {
                if (type == WhileType.INT && arithmeticStack.size() > 1) {
                    WhileArithmeticExpression right = arithmeticStack.pop();
                    WhileArithmeticExpression left = arithmeticStack.pop();
                    booleanStack.add(new WhileEq<>(left, right));
                    break;
                } else if (type == WhileType.BOOL && booleanStack.size() > 1) {
                    WhileBooleanExpression right = booleanStack.pop();
                    WhileBooleanExpression left = booleanStack.pop();
                    booleanStack.add(new WhileEq<>(left, right));
                    break;
                } else if (type == WhileType.STRING && stringsStack.size() > 1) {
                    WhileStringExpression right = stringsStack.pop();
                    WhileStringExpression left = stringsStack.pop();
                    booleanStack.add(new WhileEq<>(left, right));
                }
            }
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(LE)) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            booleanStack.add(new WhileLeq(left, right));
        }
        if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(LT)) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            booleanStack.add(new WhileLt(left, right));
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(GE)) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            booleanStack.add(new WhileGeq(left, right));
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(GT)) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            booleanStack.add(new WhileGt(left, right));
        } else if (ctx.children.size() == 2 && ctx.children.get(0).getText().equals(NOT)) {
            WhileBooleanExpression expression = booleanStack.pop();
            booleanStack.add(new WhileNot(expression));
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(AND)) {
            WhileBooleanExpression right = booleanStack.pop();
            WhileBooleanExpression left = booleanStack.pop();
            booleanStack.add(new WhileAnd(left, right));
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(OR)) {
            WhileBooleanExpression right = booleanStack.pop();
            WhileBooleanExpression left = booleanStack.pop();
            booleanStack.add(new WhileOr(left, right));
        }
    }

    /**
     * The method creates the class representation of the string expressions (string constants and string variables)
     * and adds it to the string expressions stack.
     * @param ctx the parse tree
     * @throws VariableNotDeclaredException if the encountered variable was not yet declared in the program
     */
    @Override
    public void exitStrexpr(WhileParser.StrexprContext ctx) {
        super.exitStrexpr(ctx);

        String string = ctx.getChild(0).getText();

        if (STRING_PATTERN.matcher(string).matches()) {
            String stringValue = string.substring(1, string.length() - 1);
            stringsStack.add(new WhileString(stringValue));
        } else if (VAR_PATTERN.matcher(string).matches()) {
            if (variables.containsKey(string)) {
                WhileVar var = variables.get(string);
                if (!var.getType().equals(WhileType.STRING)) {
                    throw new IncompatibleTypeException(ctx, var, WhileType.STRING);
                }
                stringsStack.add((WhileStringVar) var);
            } else {
                throw new VariableNotDeclaredException(ctx, string);
            }
        }
    }
}
