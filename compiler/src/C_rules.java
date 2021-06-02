public class C_rules extends CBaseVisitor<String[]>
{
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public String[] visitGlobalDeclaration(CParser.GlobalDeclarationContext ctx)
    {
        CParser.DeclarationSpecifiersContext declarationSpecifiers = ctx.declaration().declarationSpecifiers();
        int numOfBranches = declarationSpecifiers.getChildCount();
        //variable
        if(numOfBranches == 2)
        {
            String type = declarationSpecifiers.declarationSpecifier(0).getText();
            String id = declarationSpecifiers.declarationSpecifier(1).getText();
            System.out.print("line: " + ctx.start.getLine());
            System.out.println( " Variable : " +id + " it's type is "+ type + " and it is global");

        }
        //Struct or union or enum
        else if(numOfBranches == 1)
        {
            String[] typeAndID = visit(declarationSpecifiers.declarationSpecifier(0).typeSpecifier());
            String id = typeAndID[1];

            if(id.length() > 3)
            {
                if(id.charAt(0) == 'S' && id.charAt(1) <= 't' && id.charAt(2) == 'd')
                {
                    if(id.charAt(id.length() - 1) == 's')
                    {
                        System.out.print("line: " + ctx.start.getLine());
                        System.out.println( " Variable : " +typeAndID[2] + " it's type is "+ typeAndID[3] + " is Local");
                        if(id.charAt(id.length() - 2) == '_' && id.charAt(3) == '_')
                        {
                            System.out.print("The Name of the struct is : ");
                            System.out.print(id);
                            System.out.println("  and it is global");

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
                            System.out.print(id);
                            System.out.println("  and it is global");
                        }
                        else
                        {
                            System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
                            System.out.println("You Must Write the name of the Union like Std_Name_u");
                        }
                    }
                    else if (id.charAt(id.length() - 1) == 'e')
                    {
                        if(id.charAt(id.length() - 2) == '_' && id.charAt(3) == '_')
                        {
                            System.out.print("The Name of the enum is : ");
                            System.out.print(id);
                            System.out.println(" and it is global");
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
                        System.out.println("You Must Write the name of the Struct or union or enum like Std_Name_s or Std_Name_u or Std_Name_e");
                    }
                }
                else
                {
                    System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
                    System.out.println("You Must Write the name of the Struct or union or enum like Std_Name_s or Std_Name_u or Std_Name_e");
                }
            }
            else
            {
                System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
                System.out.println("You Must Write the name of the Struct or union or enum like Std_Name_s or Std_Name_u or Std_Name_e");
            }

        }

        String[] s = {ctx.getText()};
        return s;
    }

    //blockItem: declaration
    @Override public String[] visitLocalDeclaration(CParser.LocalDeclarationContext ctx)
    {
        CParser.DeclarationSpecifiersContext declarationSpecifiers = ctx.declaration().declarationSpecifiers();
        int numOfBranches = declarationSpecifiers.getChildCount();

        if(numOfBranches == 2)
        {
            String type = declarationSpecifiers.declarationSpecifier(0).getText();
            String id = declarationSpecifiers.declarationSpecifier(1).getText();
            System.out.print("line: " + ctx.start.getLine());
            System.out.println( " Variable : " +id + " it's type is "+ type + " and it is Local");

        }
        //Struct or union or enum
        else if(numOfBranches == 1)
        {
            String[] typeAndID = visit(declarationSpecifiers.declarationSpecifier(0).typeSpecifier());
            String id = typeAndID[1];
            System.out.println( "Variable " +typeAndID[2] + " it's type is "+ typeAndID[3] + " is Local");
            if(id.length() > 3)
            {
                if(id.charAt(0) == 'S' && id.charAt(1) <= 't' && id.charAt(2) == 'd')
                {
                    if(id.charAt(id.length() - 1) == 's')
                    {
                        if(id.charAt(id.length() - 2) == '_' && id.charAt(3) == '_')
                        {
                            System.out.print("The Name of the struct is : ");
                            System.out.print(id);
                            System.out.println("  and it is Local");
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
                            System.out.println("  and it is Local");
                        }
                        else
                        {
                            System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
                            System.out.println("You Must Write the name of the Union like Std_Name_u");
                        }
                    }
                    else if (id.charAt(id.length() - 1) == 'e')
                    {
                        if(id.charAt(id.length() - 2) == '_' && id.charAt(3) == '_')
                        {
                            System.out.print("The Name of the enum is : ");
                            System.out.println(id);
                            System.out.println("  and it is Local");
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
                        System.out.println("You Must Write the name of the Struct or union or enum like Std_Name_s or Std_Name_u or Std_Name_e");
                    }
                }
                else
                {
                    System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
                    System.out.println("You Must Write the name of the Struct or union or enum like Std_Name_s or Std_Name_u or Std_Name_e");
                }
            }
            else
            {
                System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine());
                System.out.println("You Must Write the name of the Struct or union or enum like Std_Name_s or Std_Name_u or Std_Name_e");
            }

        }

        String[] s = {ctx.getText()};
        return s;
    }
    @Override public String[] visitTypeSpecifierStructOrUnion(CParser.TypeSpecifierStructOrUnionContext ctx) {
        String type = ctx.structOrUnionSpecifier().structOrUnion().getText();
        String id = ctx.structOrUnionSpecifier().Identifier().getText();

        String Var_type = ctx.structOrUnionSpecifier().structDeclarationList().structDeclaration(0).specifierQualifierList().typeSpecifier().getText();
        String Var_name = ctx.structOrUnionSpecifier().structDeclarationList().structDeclaration(0).specifierQualifierList().specifierQualifierList().typeSpecifier().getText();
        String[] typeAndName = {type,id , Var_name , Var_type};

        return typeAndName;
    }
    @Override public String[] visitTypeSpecifierEnum(CParser.TypeSpecifierEnumContext ctx) {

        String type = ctx.enumSpecifier().Enum().getText();
        String id = ctx.enumSpecifier().Identifier().getText();


        String[] typeAndName = {type,id };

        return typeAndName ;
    }
    /*@Override public String[] visitFunctionDefinition(CParser.FunctionDefinitionContext ctx)
    {
        String type = ctx.declarationSpecifiers().declarationSpecifier(2).typeSpecifier().getText();
        String id   = ctx.declarator().directDeclarator().Identifier().getText();
        System.out.print("line: " + ctx.start.getLine());
        System.out.println( " Function name is : " +id + " it's type is "+ type );

        String[] typeAndId = {type,id };
        return typeAndId ;
    }*/

}
