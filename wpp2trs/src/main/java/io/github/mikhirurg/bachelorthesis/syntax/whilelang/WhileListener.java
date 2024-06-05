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

public class WhileListener extends WhileBaseListener {
    private final Stack<WhileArithmeticExpression> arithmeticStack;
    private final Stack<WhileBooleanExpression> booleanStack;
    private final Stack<WhileStringExpression> stringsStack;
    private final Stack<WhileStatement> statementStack;

    private HashMap<String, WhileVar> variables;
    private HashMap<String, WhileVar> tmpVariables;

    private static final Pattern VAR_PATTERN = Pattern.compile("[a-zA-Z]+");
    private static final Pattern INT_PATTERN = Pattern.compile("[0-9]+");
    private static final Pattern STRING_PATTERN = Pattern.compile("\"(.*)\"");

    private static final String NOT = "not";
    private static final String AND = "and";
    private static final String OR = "or";
    private static final String EQ = "=";
    private static final String GT = ">";
    private static final String LT = "<";
    private static final String GE = ">=";
    private static final String LE = "<=";
    private static final String SEMICOLON = ";";
    private static final String INT_TYPE = "int";
    private static final String BOOL_TYPE = "bool";
    private static final String STRING_TYPE = "string";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULT = "*";
    private static final String DIV = "/";
    private static final String MOD = "%";
    private static final String TRUE = "true";
    private static final String FALSE = "false";

    private WhileStatement program;

    public WhileListener() {
        this.arithmeticStack = new Stack<>();
        this.booleanStack = new Stack<>();
        this.statementStack = new Stack<>();
        this.variables = new HashMap<>();
        this.tmpVariables = new HashMap<>();
        this.stringsStack = new Stack<>();
    }

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

    private void processVariable(WhileVar var) {
        if (var.getType() == WhileType.INT) {
            arithmeticStack.add((WhileIntVar) var);
        } else if (var.getType() == WhileType.BOOL) {
            booleanStack.add((WhileBoolVar) var);
        } else if (var.getType() == WhileType.STRING) {
            stringsStack.add((WhileStringVar) var);
        }
    }

    public WhileStatement getProgram() {
        return program;
    }

    @Override
    public void enterIfStm(WhileParser.IfStmContext ctx) {
        super.enterIfStm(ctx);

        tmpVariables = new HashMap<>(variables);
    }

    @Override
    public void enterWhileStm(WhileParser.WhileStmContext ctx) {
        super.enterWhileStm(ctx);

        tmpVariables = new HashMap<>(variables);
    }

    @Override
    public void exitProg(WhileParser.ProgContext ctx) {
        super.exitProg(ctx);

        this.program = statementStack.pop();
    }

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

    @Override
    public void exitIfStm(WhileParser.IfStmContext ctx) {
        super.exitIfStm(ctx);

        WhileBooleanExpression expression = booleanStack.pop();
        WhileStatement s2 = statementStack.pop();
        WhileStatement s1 = statementStack.pop();
        statementStack.add(new WhileIf(expression, s1, s2));
    }

    @Override
    public void exitNestedStm(WhileParser.NestedStmContext ctx) {
        super.exitNestedStm(ctx);
        variables = new HashMap<>(tmpVariables);
    }

    @Override
    public void exitPrintBoolStm(WhileParser.PrintBoolStmContext ctx) {
        super.exitPrintBoolStm(ctx);

        if (!booleanStack.isEmpty()) {
            statementStack.add(new WhilePrintBool(booleanStack.pop()));
        } else {
            throw new ExpectedTypeException(ctx, WhileType.BOOL);
        }
    }

    @Override
    public void exitPrintIntStm(WhileParser.PrintIntStmContext ctx) {
        super.exitPrintIntStm(ctx);

        if (!arithmeticStack.isEmpty()) {
            statementStack.add(new WhilePrintInt(arithmeticStack.pop()));
        } else {
            throw new ExpectedTypeException(ctx, WhileType.INT);
        }
    }

    @Override
    public void exitReadBoolStm(WhileParser.ReadBoolStmContext ctx) {
        super.exitReadBoolStm(ctx);

        String varName = ctx.children.get(2).getText();
        if (variables.containsKey(varName)) {
            statementStack.add(new WhileReadBool(variables.get(varName)));
        } else {
            throw new ExpectedTypeException(ctx, WhileType.BOOL);
        }
    }

    @Override
    public void exitReadIntStm(WhileParser.ReadIntStmContext ctx) {
        super.exitReadIntStm(ctx);

        String varName = ctx.children.get(2).getText();
        if (variables.containsKey(varName)) {
            statementStack.add(new WhileReadInt(variables.get(varName)));
        } else {
            throw new ExpectedTypeException(ctx, WhileType.INT);
        }
    }

    @Override
    public void exitPrintStringStm(WhileParser.PrintStringStmContext ctx) {
        super.exitPrintStringStm(ctx);

        if (!stringsStack.isEmpty()) {
            statementStack.add(new WhilePrintString(stringsStack.pop()));
        } else {
            throw new ExpectedTypeException(ctx, WhileType.STRING);
        }
    }

    @Override
    public void exitReadStringStm(WhileParser.ReadStringStmContext ctx) {
        super.exitReadStringStm(ctx);

        String varName = ctx.children.get(2).getText();
        if (variables.containsKey(varName)) {
            statementStack.add(new WhileReadString(variables.get(varName)));
        } else {
            throw new ExpectedTypeException(ctx, WhileType.STRING);
        }
    }

    @Override
    public void exitSkipStm(WhileParser.SkipStmContext ctx) {
        super.exitSkipStm(ctx);

        statementStack.add(new WhileSkip());
    }

    @Override
    public void exitWhileStm(WhileParser.WhileStmContext ctx) {
        super.exitWhileStm(ctx);

        variables = new HashMap<>(tmpVariables);
        WhileBooleanExpression expression = booleanStack.pop();
        WhileStatement statement = statementStack.pop();
        statementStack.add(new WhileWhile(expression, statement));
    }

    @Override
    public void exitUntypedexpr(WhileParser.UntypedexprContext ctx) {
        super.exitUntypedexpr(ctx);
        String varName = ctx.children.getFirst().getText();
        if (variables.containsKey(varName)) {
            WhileVar var = variables.get(varName);
            processVariable(var);
        }
    }

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
