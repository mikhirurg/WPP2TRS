package io.github.mikhirurg.bachelorthesis.syntax.whilelang.gen;// Generated from /home/mikhirurg/IdeaProjects/BachelorThesis/src/main/antlr4/While.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WhileParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WhileVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WhileParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(WhileParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStm(WhileParser.StmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#unaryStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryStm(WhileParser.UnaryStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#declareStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareStm(WhileParser.DeclareStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#assignStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStm(WhileParser.AssignStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#skipStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipStm(WhileParser.SkipStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#printIntStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintIntStm(WhileParser.PrintIntStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#printStringStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStringStm(WhileParser.PrintStringStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#printBoolStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintBoolStm(WhileParser.PrintBoolStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#readIntStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadIntStm(WhileParser.ReadIntStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#readStringStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStringStm(WhileParser.ReadStringStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#readBoolStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadBoolStm(WhileParser.ReadBoolStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#ifStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStm(WhileParser.IfStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#branchOne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchOne(WhileParser.BranchOneContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#branchTwo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchTwo(WhileParser.BranchTwoContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#whileStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStm(WhileParser.WhileStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#whileBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileBody(WhileParser.WhileBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(WhileParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#blockStm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStm(WhileParser.BlockStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(WhileParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#untypedexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntypedexpr(WhileParser.UntypedexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#typedexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedexpr(WhileParser.TypedexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexp(WhileParser.AexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#aexpatom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpatom(WhileParser.AexpatomContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexp(WhileParser.BexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#bexpatom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexpatom(WhileParser.BexpatomContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#strexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrexpr(WhileParser.StrexprContext ctx);
}