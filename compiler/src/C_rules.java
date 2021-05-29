public class C_rules extends CBaseVisitor<String>
{

    @Override public String visitStructDecl(CParser.StructDeclContext ctx)
    {
        String id = ctx.Identifier().getText();
        if(id.length() > 3)
        {
            if(id.charAt(0) == 'S' && id.charAt(1) <= 't' && id.charAt(2) == 'd')
            {
                if(id.charAt(id.length() - 1) == 's')
                {
                    System.out.print("The Name of the struct is : ");
                    System.out.println(id);
                }
                else
                {
                    System.out.println("You Must Write the name of the Struct like Std_Name_s");
                }
            }
        }
        else
        {
            System.out.println("You Must Write the name of the Struct like Std_Name_s");
        }
        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public String visitStructId(CParser.StructIdContext ctx)
    {
        return visitChildren(ctx);
    }
}
