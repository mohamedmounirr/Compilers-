public class C_rules extends CBaseVisitor<String>
{
   /* @Override public String visitStructDecl(CParser.StructDeclContext ctx)
    {
        String id = ctx.Identifier().getText();
        if(id.length() > 3)
        {
            if(id.charAt(0) == 'S' && id.charAt(1) <= 't' && id.charAt(2) == 'd')
            {
                if(id.charAt(id.length() - 1) == 's')
                {
                    if(id.charAt(id.length() - 2) == '_' && id.charAt(3) == '_')
                    {
                        System.out.print("The Name of the struct is : ");
                        System.out.println(id);
                    }
                    else
                    {
                        System.out.println("You Must Write the name of the Struct like Std_Name_s1");
                    }
                }
                else if(id.charAt(id.length() - 1) == 'u')
                {
                    System.out.print("The Name of the Union is : ");
                    System.out.println(id);
                }
                else
                {
                    System.out.println("You Must Write the name of the Struct like Std_Name_s2");
                }
            }
            else
            {
                System.out.println("You Must Write the name of the Struct like Std_Name_s3");
            }
        }
        else
        {
            System.out.println("You Must Write the name of the Struct like Std_Name_s4");
        }


        return visitChildren(ctx);
    }
    */

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public String visitGlobalDeclaration(CParser.GlobalDeclarationContext ctx)
    {
        CParser.DeclarationSpecifiersContext declarationSpecifiers = ctx.declaration().declarationSpecifiers();
        int numOfBranches = declarationSpecifiers.getChildCount();

        //variable
        if(numOfBranches == 2)
        {
            String type = declarationSpecifiers.declarationSpecifier(0).getText();
            String id = declarationSpecifiers.declarationSpecifier(1).getText();

        }
        //Struct or union or enum
        else if(numOfBranches == 1)
        {
            String typeAndID = visit(declarationSpecifiers.declarationSpecifier(0).typeSpecifier());

        }


        return "";
    }

    //blockItem: declaration
    @Override public String visitLocalDeclaration(CParser.LocalDeclarationContext ctx)
    {
        System.out.println(ctx.getText() + " in line: " + ctx.start.getLine() + "is Local");
        return "";
    }
    @Override public String visitTypeSpecifierStructOrUnion(CParser.TypeSpecifierStructOrUnionContext ctx) {
        String type = ctx.structOrUnionSpecifier().structOrUnion().getText();
        String id = ctx.structOrUnionSpecifier().Identifier().getText();

        if(id.length() > 3)
        {
            if(id.charAt(0) == 'S' && id.charAt(1) <= 't' && id.charAt(2) == 'd')
            {
                if(id.charAt(id.length() - 1) == 's')
                {
                    if(id.charAt(id.length() - 2) == '_' && id.charAt(3) == '_')
                    {
                        System.out.print("The Name of the struct is : ");
                        System.out.println(id);
                    }
                    else
                    {
                        System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
                        System.out.println("You Must Write the name of the Struct like Std_Name_s");
                    }
                }
                else if(id.charAt(id.length() - 1) == 'u')
                {
                    if(id.charAt(id.length() - 2) == '_' && id.charAt(3) == '_')
                    {
                        System.out.print("The Name of the union is : ");
                        System.out.println(id);
                    }
                    else
                    {
                        System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
                        System.out.println("You Must Write the name of the Union like Std_Name_u");
                    }
                }
                else
                {
                    System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
                    System.out.println("You Must Write the name of the Struct or union like Std_Name_s or Std_Name_u");
                }
            }
            else
            {
                System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
                System.out.println("You Must Write the name of the Struct or union like Std_Name_s or Std_Name_u");
            }
        }
        else
        {
            System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
            System.out.println("You Must Write the name of the Struct or union like Std_Name_s or Std_Name_u");
        }

        return visitChildren(ctx);
    }
    @Override public String visitTypeSpecifierEnum(CParser.TypeSpecifierEnumContext ctx) {

        String type = ctx.enumSpecifier().Enum().getText();
        String id = ctx.enumSpecifier().Identifier().getText();
        if(id.length() > 3)
        {
            if(id.charAt(0) == 'S' && id.charAt(1) <= 't' && id.charAt(2) == 'd')
            {
                if(id.charAt(id.length() - 1) == 'e')
                {
                    if(id.charAt(id.length() - 2) == '_' && id.charAt(3) == '_')
                    {
                        System.out.print("The Name of the enum is : ");
                        System.out.println(id);
                    }
                    else
                    {
                        System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
                        System.out.println("You Must Write the name of the enum like Std_Name_e");
                    }
                }
                else
                {
                    System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
                    System.out.println("You Must Write the name of the enum like Std_Name_e");
                }
            }
            else
            {
                System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
                System.out.println("You Must Write the name of the enum like Std_Name_e");
            }
        }
        else
        {
            System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
            System.out.println("You Must Write the name of the enum like Std_Name_e");
        }
        return "";
    }

}
