public class UnicodeTranslator extends ArrayInitBaseListener
{
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterArrayinit(ArrayInitParser.ArrayinitContext ctx)
    {
        System.out.println("\"");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitArrayinit(ArrayInitParser.ArrayinitContext ctx)
    {
        System.out.println("\"");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterList(ArrayInitParser.ListContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitList(ArrayInitParser.ListContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterObj(ArrayInitParser.ObjContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitObj(ArrayInitParser.ObjContext ctx) { }
}
