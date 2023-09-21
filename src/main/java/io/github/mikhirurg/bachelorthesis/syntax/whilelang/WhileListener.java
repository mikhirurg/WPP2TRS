package io.github.mikhirurg.bachelorthesis.syntax.whilelang;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.gen.WhileBaseListener;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.gen.WhileParser;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileString;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileStringExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.exceptions.DuplicateVariableDeclarationException;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.exceptions.IncompatibleTypeException;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.exceptions.VariableNotDeclaredException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;

public class WhileListener extends WhileBaseListener {
    private final Stack<WhileArithmeticExpression> arithmeticStack;

    private final Stack<WhileBooleanExpression> booleanStack;

    private final Stack<WhileString> stringsStack;

    private final Stack<WhileStatement> statementStack;

    private final HashMap<String, WhileVar> variables;

    private static final Pattern VAR_PATTERN = Pattern.compile("[a-zA-Z]+");

    private static final Pattern INT_PATTERN = Pattern.compile("[0-9]+");

    private WhileStatement program;

    public WhileListener() {
        this.arithmeticStack = new Stack<>();
        this.booleanStack = new Stack<>();
        this.statementStack = new Stack<>();
        this.variables = new HashMap<>();
        stringsStack = new Stack<>();
    }

    public WhileStatement getProgram() {
        return program;
    }

    @Override
    public void exitProg(WhileParser.ProgContext ctx) {
        super.exitProg(ctx);

        this.program = statementStack.pop();
    }

    @Override
    public void exitStm(WhileParser.StmContext ctx) {
        super.exitStm(ctx);
        if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(";")) {
            WhileStatement s2 = statementStack.pop();
            WhileStatement s1 = statementStack.pop();
            statementStack.add(new WhileComp(s1, s2));
        } else if (ctx.children.size() == 4 && ctx.children.get(2).getText().equals(":=")) {

            String varName = ctx.children.get(1).getText();

            WhileVarType varType = switch (ctx.children.get(0).getText()) {
                case "bool" -> WhileVarType.BOOL;
                case "string" -> WhileVarType.STRING;
                default -> WhileVarType.INT;
            };

            WhileVar variable;
            if (variables.containsKey(varName)) {
                throw new DuplicateVariableDeclarationException(variables.get(varName));
            } else {
                switch (varType) {
                    case STRING: {
                        variable = new WhileStringVar(varName);
                        statementStack.add(new WhileVarDeclaration(variable, stringsStack.pop()));
                    }
                    case BOOL: {
                        variable = new WhileBoolVar(varName);
                        statementStack.add(new WhileVarDeclaration(variable, booleanStack.pop()));
                    }
                    case INT:
                    default: {
                        variable = new WhileIntVar(varName);
                        statementStack.add(new WhileVarDeclaration(variable, arithmeticStack.pop()));
                    }
                }

                variables.put(varName, variable);
            }
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals(":=")) {

            String varName = ctx.children.get(0).getText();

            if (variables.containsKey(varName)) {
                WhileVar variable = variables.get(varName);
                switch (variable.getType()) {
                    case STRING: {
                        WhileStringExpression stringExpression = stringsStack.pop();
                        statementStack.add(new WhileAssignment(variable, stringExpression));
                    }
                    case BOOL: {
                        WhileBooleanExpression booleanExpression = booleanStack.pop();
                        statementStack.add(new WhileAssignment(variable, booleanExpression));
                    }
                    case INT:
                    default: {
                        WhileArithmeticExpression arithmeticExpression = arithmeticStack.pop();
                        statementStack.add(new WhileAssignment(variable, arithmeticExpression));
                    }
                }
            } else {
                throw new VariableNotDeclaredException(varName);
            }
        } else if (ctx.children.size() == 1 && ctx.children.get(0).getText().equals("skip")) {
            statementStack.add(new WhileSkip());
        } else if (ctx.children.size() == 6 && ctx.children.get(0).getText().equals("if")) {
            WhileBooleanExpression expression = booleanStack.pop();
            WhileStatement s2 = statementStack.pop();
            WhileStatement s1 = statementStack.pop();
            statementStack.add(new WhileIf(expression, s1, s2));
        } else if (ctx.children.size() == 4 && ctx.children.get(0).getText().equals("while")) {
            WhileBooleanExpression expression = booleanStack.pop();
            WhileStatement statement = statementStack.pop();
            statementStack.add(new WhileWhile(expression, statement));
        }
    }

    @Override
    public void exitAexp(WhileParser.AexpContext ctx) {
        super.exitAexp(ctx);
        if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals("+")) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            arithmeticStack.add(new WhilePlus(left, right));
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals("-")) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            arithmeticStack.add(new WhileSub(left, right));
        }
    }

    @Override
    public void exitMultExpr(WhileParser.MultExprContext ctx) {
        super.exitMultExpr(ctx);
        if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals("*")) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            arithmeticStack.add(new WhileMult(left, right));
        }
    }

    @Override
    public void exitAtom(WhileParser.AtomContext ctx) {
        super.exitAtom(ctx);
        if (ctx.children.size() == 1) {
            if (VAR_PATTERN.matcher(ctx.children.get(0).getText()).matches()) {
                String varName = ctx.children.get(0).getText();
                if (variables.containsKey(varName)) {
                    WhileVar var = variables.get(varName);
                    if (var.getType() == WhileVarType.INT) {
                        arithmeticStack.add(new WhileIntVar(ctx.children.get(0).getText()));
                    } else {
                        throw new IncompatibleTypeException(var, WhileVarType.INT);
                    }
                } else {
                    throw new VariableNotDeclaredException(varName);
                }

            } else if (INT_PATTERN.matcher(ctx.children.get(0).getText()).matches()) {
                arithmeticStack.add(new WhileConst(ctx.children.get(0).getText()));
            }
        }
    }

    @Override
    public void exitBexp(WhileParser.BexpContext ctx) {
        super.exitBexp(ctx);
        if (ctx.children.size() == 1 && ctx.children.get(0).getText().equals("true")) {
            booleanStack.add(new WhileTrueConst());
        } else if (ctx.children.size() == 1 && ctx.children.get(0).getText().equals("false")) {
            booleanStack.add(new WhileFalseConst());
        } else if (ctx.children.size() == 1 && VAR_PATTERN.matcher(ctx.children.get(0).getText()).matches()) {
            String varName = ctx.children.get(0).getText();
            if (variables.containsKey(varName)) {
                WhileVar var = variables.get(varName);
                if (var.getType() == WhileVarType.BOOL) {
                    booleanStack.add(new WhileBoolVar(ctx.children.get(0).getText()));
                } else {
                    throw new IncompatibleTypeException(var, WhileVarType.BOOL);
                }
            } else {
                throw new VariableNotDeclaredException(varName);
            }
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals("=")) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            booleanStack.add(new WhileEq(left, right));
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals("<=")) {
            WhileArithmeticExpression right = arithmeticStack.pop();
            WhileArithmeticExpression left = arithmeticStack.pop();
            booleanStack.add(new WhileLeq(left, right));
        } else if (ctx.children.size() == 4 && ctx.children.get(0).getText().equals("not")) {
            WhileBooleanExpression expression = booleanStack.pop();
            booleanStack.add(new WhileNot(expression));
        } else if (ctx.children.size() == 3 && ctx.children.get(1).getText().equals("and")) {
            WhileBooleanExpression right = booleanStack.pop();
            WhileBooleanExpression left = booleanStack.pop();
            booleanStack.add(new WhileAnd(left, right));
        }
    }

    @Override
    public void exitStrexp(WhileParser.StrexpContext ctx) {
        super.exitStrexp(ctx);
        if (ctx.children.size() == 3) {
            String str = ctx.children.get(1).getText();
            stringsStack.add(new WhileString(str));
        }
    }
}
