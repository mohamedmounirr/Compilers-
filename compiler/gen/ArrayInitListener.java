// Generated from C:/Users/Mounir/IdeaProjects/compiler/src\ArrayInit.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArrayInitParser}.
 */
public interface ArrayInitListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArrayInitParser#arrayinit}.
	 * @param ctx the parse tree
	 */
	void enterArrayinit(ArrayInitParser.ArrayinitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayInitParser#arrayinit}.
	 * @param ctx the parse tree
	 */
	void exitArrayinit(ArrayInitParser.ArrayinitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayInitParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(ArrayInitParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayInitParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(ArrayInitParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayInitParser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(ArrayInitParser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayInitParser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(ArrayInitParser.ObjContext ctx);
}