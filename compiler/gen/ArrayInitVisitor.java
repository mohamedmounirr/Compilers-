// Generated from C:/Users/Mounir/IdeaProjects/compiler/src\ArrayInit.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArrayInitParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArrayInitVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ArrayInitParser#arrayinit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayinit(ArrayInitParser.ArrayinitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArrayInitParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(ArrayInitParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArrayInitParser#obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(ArrayInitParser.ObjContext ctx);
}