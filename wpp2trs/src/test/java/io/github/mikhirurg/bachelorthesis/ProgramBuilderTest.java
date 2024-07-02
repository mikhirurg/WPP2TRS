package io.github.mikhirurg.bachelorthesis;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileConst;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhilePlus;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileSub;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileFalseConst;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileLeq;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileOr;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileTrueConst;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print.WhilePrintInt;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileString;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileBoolVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileIntVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileStringVar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramBuilderTest {

    @Test
    void testTypeDeclareInt() {
        String program = "int x := 1";

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(new WhileVarDeclaration(
                new WhileIntVar("x"),
                new WhileConst("1")
        ), statement);
    }

    @Test
    void testTypeDeclareBool() {
        String program = "bool b := (true or false)";

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(new WhileVarDeclaration(
                new WhileBoolVar("b"),
                new WhileOr(new WhileTrueConst(),
                        new WhileFalseConst())
        ), statement);
    }

    @Test
    void testTypeDeclareString() {
        String program = "string str := \"Hello world!\"";

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(new WhileVarDeclaration(
                new WhileStringVar("str"),
                new WhileString("Hello world!")
        ), statement);
    }

    @Test
    void testIntVarAssignmentNotDeclared() {
        String program = "x := 1";

        assertThrows(VariableNotDeclaredException.class, () -> ProgramBuilder.parseProgram(program));
    }

    @Test
    void testStringVarAssignmentNotDeclared() {
        String program = "x := \"str\"";

        assertThrows(VariableNotDeclaredException.class, () -> ProgramBuilder.parseProgram(program));
    }

    @Test
    void testBoolVarAssignmentNotDeclared() {
        String program = "x := false";

        assertThrows(VariableNotDeclaredException.class, () -> ProgramBuilder.parseProgram(program));
    }

    @Test
    void testDuplicateVariableDeclaration() {
        String program = "int x := 1; int x := 2";

        assertThrows(DuplicateVariableDeclarationException.class, () -> ProgramBuilder.parseProgram(program));
    }

    @Test
    void testExpectedStatement() {
        String program = "int x := 1;";

        assertThrows(ExpectedStatementException.class, () -> ProgramBuilder.parseProgram(program));
    }

    @Test
    void testIncompatibleType() {
        String program = "int x := 1; printString(x)";

        assertThrows(IncompatibleTypeException.class, () -> ProgramBuilder.parseProgram(program));
    }

    @Test
    void testIntVarAssignment() {
        String program = "int x := 1; x := x + 1 + 2 + 3 + 4";

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(
                new WhileComp(
                        new WhileVarDeclaration(
                                new WhileIntVar("x"),
                                new WhileConst("1")
                        ),
                        new WhileAssignment(
                                new WhileIntVar("x"),
                                new WhilePlus(
                                        new WhilePlus(
                                                new WhilePlus(
                                                        new WhilePlus(
                                                                new WhileIntVar("x"),
                                                                new WhileConst("1")
                                                        ),
                                                        new WhileConst("2")
                                                ),
                                                new WhileConst("3")
                                        ),
                                        new WhileConst("4")
                                )
                        )
                ),
                statement
        );
    }

    @Test
    void testStringVarAssignment() {
        String program = "string x := \"abc\"; x := \"cde\"";

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(
                new WhileComp(
                        new WhileVarDeclaration(
                                new WhileStringVar("x"),
                                new WhileString("abc")
                        ),
                        new WhileAssignment(
                                new WhileStringVar("x"),
                                new WhileString("cde")
                        )
                ),
                statement
        );
    }

    @Test
    void testBoolVarAssignment() {
        String program = "bool b := false; b := (10 <= (20 + 10 + 30))";

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(
                new WhileComp(
                        new WhileVarDeclaration(
                                new WhileBoolVar("b"),
                                new WhileFalseConst()
                        ),
                        new WhileAssignment(
                                new WhileBoolVar("b"),
                                new WhileLeq(
                                        new WhileConst("10"),
                                        new WhilePlus(
                                                new WhilePlus(
                                                        new WhileConst("20"),
                                                        new WhileConst("10")
                                                ),
                                                new WhileConst("30")
                                        )
                                )
                        )), statement
        );
    }

    @Test
    void testSkip() {
        String program = "skip";

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(new WhileSkip(), statement);
    }

    @Test
    void testComp1() {
        String program = "skip; skip";

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(new WhileComp(new WhileSkip(), new WhileSkip()), statement);
    }

    @Test
    void testComp2() {
        String program = "(skip; skip)";

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(new WhileComp(new WhileSkip(), new WhileSkip()), statement);
    }

    @Test
    void testComp3() {
        String program = "(((skip; skip)))";

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(new WhileComp(new WhileSkip(), new WhileSkip()), statement);
    }

    @Test
    void testComp4() {
        String program = "(((skip)); skip)";

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(new WhileComp(new WhileSkip(), new WhileSkip()), statement);
    }

    @Test
    void testComp5() {
        String program = "skip; skip; skip";

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(new WhileComp(
                new WhileComp(
                        new WhileSkip(),
                        new WhileSkip()),
                new WhileSkip()
        ), statement);
    }

    @Test
    void testNestedIfs() {
        String program = """
                if (true) then
                    if true then
                        if true then
                            printInt(1)
                        else skip
                    else skip
                else skip
                """;

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(
                new WhileIf(
                        new WhileTrueConst(),
                        new WhileIf(
                                new WhileTrueConst(),
                                new WhileIf(
                                        new WhileTrueConst(),
                                        new WhilePrintInt(new WhileConst("1")),
                                        new WhileSkip()
                                ), new WhileSkip()
                        ), new WhileSkip()
                ), statement);
    }

    @Test
    void testNestedWhiles() {
        String program = """
                while true do
                    while false do
                        while true do
                            skip
                """;

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(
                new WhileWhile(
                        new WhileTrueConst(),
                        new WhileWhile(
                                new WhileFalseConst(),
                                new WhileWhile(
                                        new WhileTrueConst(),
                                        new WhileSkip()
                                )
                        )
                ), statement);
    }

    @Test
    void testNestedIfsAndWhiles() {
        String program = """
                while true do
                    if true then
                        while false do
                            skip
                    else
                        if false then
                            while false do
                                skip
                        else
                            skip
                """;

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(
                new WhileWhile(
                        new WhileTrueConst(),
                        new WhileIf(
                                new WhileTrueConst(),
                                new WhileWhile(
                                        new WhileFalseConst(),
                                        new WhileSkip()
                                ),
                                new WhileIf(
                                        new WhileFalseConst(),
                                        new WhileWhile(
                                                new WhileFalseConst(),
                                                new WhileSkip()
                                        ),
                                        new WhileSkip()
                                )
                        )
                ), statement);
    }

    @Test
    void testWhileMultipleStmBody() {
        String program = """
                while true do (
                    skip;
                    skip;
                    skip
                )
                """;

        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(new WhileWhile(
                new WhileTrueConst(),
                new WhileComp(
                        new WhileComp(
                                new WhileSkip(),
                                new WhileSkip()
                        ),
                        new WhileSkip()
                )
        ), statement);
    }

    @Test
    void testCompWhileSingleStm() {
        String program = """
                while true do
                    skip;
                skip
                """;
        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(new WhileComp(
                new WhileWhile(
                        new WhileTrueConst(),
                        new WhileSkip()
                ),
                new WhileSkip()
        ), statement);
    }

    @Test
    void testPrintArithmeticExpression() {
        String program = """
                printInt(10-2)
                """;
        WhileStatement statement = ProgramBuilder.parseProgram(program);

        assertEquals(new WhilePrintInt(
                new WhileSub(
                        new WhileConst("10"),
                        new WhileConst("2"))
        ), statement);
    }

}