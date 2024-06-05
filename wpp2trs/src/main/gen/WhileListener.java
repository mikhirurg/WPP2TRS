// Generated from /home/mikhirurg/IdeaProjects/BachelorThesis/src/main/antlr4/While.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WhileParser}.
 */
public interface WhileListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WhileParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(WhileParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(WhileParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterStm(WhileParser.StmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitStm(WhileParser.StmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#nestedStm}.
	 * @param ctx the parse tree
	 */
	void enterNestedStm(WhileParser.NestedStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#nestedStm}.
	 * @param ctx the parse tree
	 */
	void exitNestedStm(WhileParser.NestedStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(WhileParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(WhileParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#unaryStm}.
	 * @param ctx the parse tree
	 */
	void enterUnaryStm(WhileParser.UnaryStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#unaryStm}.
	 * @param ctx the parse tree
	 */
	void exitUnaryStm(WhileParser.UnaryStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#skipStm}.
	 * @param ctx the parse tree
	 */
	void enterSkipStm(WhileParser.SkipStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#skipStm}.
	 * @param ctx the parse tree
	 */
	void exitSkipStm(WhileParser.SkipStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#printIntStm}.
	 * @param ctx the parse tree
	 */
	void enterPrintIntStm(WhileParser.PrintIntStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#printIntStm}.
	 * @param ctx the parse tree
	 */
	void exitPrintIntStm(WhileParser.PrintIntStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#printStringStm}.
	 * @param ctx the parse tree
	 */
	void enterPrintStringStm(WhileParser.PrintStringStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#printStringStm}.
	 * @param ctx the parse tree
	 */
	void exitPrintStringStm(WhileParser.PrintStringStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#printBoolStm}.
	 * @param ctx the parse tree
	 */
	void enterPrintBoolStm(WhileParser.PrintBoolStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#printBoolStm}.
	 * @param ctx the parse tree
	 */
	void exitPrintBoolStm(WhileParser.PrintBoolStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#readIntStm}.
	 * @param ctx the parse tree
	 */
	void enterReadIntStm(WhileParser.ReadIntStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#readIntStm}.
	 * @param ctx the parse tree
	 */
	void exitReadIntStm(WhileParser.ReadIntStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#readStringStm}.
	 * @param ctx the parse tree
	 */
	void enterReadStringStm(WhileParser.ReadStringStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#readStringStm}.
	 * @param ctx the parse tree
	 */
	void exitReadStringStm(WhileParser.ReadStringStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#readBoolStm}.
	 * @param ctx the parse tree
	 */
	void enterReadBoolStm(WhileParser.ReadBoolStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#readBoolStm}.
	 * @param ctx the parse tree
	 */
	void exitReadBoolStm(WhileParser.ReadBoolStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#ifStm}.
	 * @param ctx the parse tree
	 */
	void enterIfStm(WhileParser.IfStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#ifStm}.
	 * @param ctx the parse tree
	 */
	void exitIfStm(WhileParser.IfStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#whileStm}.
	 * @param ctx the parse tree
	 */
	void enterWhileStm(WhileParser.WhileStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#whileStm}.
	 * @param ctx the parse tree
	 */
	void exitWhileStm(WhileParser.WhileStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#blockStm}.
	 * @param ctx the parse tree
	 */
	void enterBlockStm(WhileParser.BlockStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#blockStm}.
	 * @param ctx the parse tree
	 */
	void exitBlockStm(WhileParser.BlockStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#declareStm}.
	 * @param ctx the parse tree
	 */
	void enterDeclareStm(WhileParser.DeclareStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#declareStm}.
	 * @param ctx the parse tree
	 */
	void exitDeclareStm(WhileParser.DeclareStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#assignStm}.
	 * @param ctx the parse tree
	 */
	void enterAssignStm(WhileParser.AssignStmContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#assignStm}.
	 * @param ctx the parse tree
	 */
	void exitAssignStm(WhileParser.AssignStmContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(WhileParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(WhileParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#untypedexpr}.
	 * @param ctx the parse tree
	 */
	void enterUntypedexpr(WhileParser.UntypedexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#untypedexpr}.
	 * @param ctx the parse tree
	 */
	void exitUntypedexpr(WhileParser.UntypedexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#typedexpr}.
	 * @param ctx the parse tree
	 */
	void enterTypedexpr(WhileParser.TypedexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#typedexpr}.
	 * @param ctx the parse tree
	 */
	void exitTypedexpr(WhileParser.TypedexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterAexp(WhileParser.AexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitAexp(WhileParser.AexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#aexpatom}.
	 * @param ctx the parse tree
	 */
	void enterAexpatom(WhileParser.AexpatomContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#aexpatom}.
	 * @param ctx the parse tree
	 */
	void exitAexpatom(WhileParser.AexpatomContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterBexp(WhileParser.BexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitBexp(WhileParser.BexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#bexpatom}.
	 * @param ctx the parse tree
	 */
	void enterBexpatom(WhileParser.BexpatomContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#bexpatom}.
	 * @param ctx the parse tree
	 */
	void exitBexpatom(WhileParser.BexpatomContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#strexpr}.
	 * @param ctx the parse tree
	 */
	void enterStrexpr(WhileParser.StrexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#strexpr}.
	 * @param ctx the parse tree
	 */
	void exitStrexpr(WhileParser.StrexprContext ctx);
}