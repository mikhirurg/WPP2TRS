// Generated from /home/mikhirurg/IdeaProjects/BachelorThesis/src/main/antlr4/While.g4 by ANTLR 4.12.0
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
	 * Visit a parse tree produced by {@link WhileParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexp(WhileParser.AexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#multExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(WhileParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(WhileParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexp(WhileParser.BexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#strexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrexpr(WhileParser.StrexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(WhileParser.ExprContext ctx);
}