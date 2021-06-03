import java.io.File;

public class C_rules extends CBaseVisitor<String[] >
{
    String Filename ;
    int [] Str_no_of_var = {0,0,0,0,0,0,0,0};
    int [] Enum_no_of_var = {0,0,0,0,0,0,0,0};
    int Str_no_of_var_index = 0 ;
    int enum_no_of_var_index = 0 ;
    public C_rules(String m) {

        Filename = m ;
    }

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
            int j =0 ;

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
                            System.out.println("  and it is global");
                            for( int i = 0 ; i < Str_no_of_var[Str_no_of_var_index-1] ; i++)
                            {
                                System.out.print("Struct " + id + " content : ");
                                System.out.println( " Variable : " +typeAndID[i+3+j] + " it's type is "+  typeAndID[i+2+j] + " is Local");
                                j++;

                            }

                        }
                        else
                        {
                            System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine() + " File Name : "+ Filename );
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
                            for( int i = 0 ; i < Str_no_of_var[Str_no_of_var_index-1] ; i++)
                            {
                                System.out.print("Union " + id + " content : ");
                                System.out.println( " Variable : " +typeAndID[i+3+j] + " it's type is "+  typeAndID[i+2+j] + " is Local");
                                j++;

                            }
                        }
                        else
                        {
                            System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine() + " File Name : "+ Filename);
                            System.out.println("You Must Write the name of the Union like Std_Name_u");
                        }
                    }
                    else if (id.charAt(id.length() - 1) == 'e')
                    {
                        if(id.charAt(id.length() - 2) == '_' && id.charAt(3) == '_')
                        {
                            System.out.print("The Name of the Enum is : ");
                            System.out.print(id);
                            System.out.println("  and it is global");
                            int index = 2;
                            for( int i = 0 ; i < Str_no_of_var[Str_no_of_var_index-1] ; i++)
                            {
                                System.out.print("Enum " + id + " content : ");
                                System.out.println( " Variable : " +typeAndID[index] +" is Local");
                                index++;
                                j++;

                            }
                        }
                        else
                        {
                            System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine() + " File Name : "+ Filename);
                            System.out.println("You Must Write the name of the enum like Std_Name_e");
                        }
                    }
                    else
                    {
                        System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine() + " File Name : "+ Filename);
                        System.out.println("You Must Write the name of the Struct or union or enum like Std_Name_s or Std_Name_u or Std_Name_e");
                    }
                }
                else
                {
                    System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine() + " File Name : "+ Filename);
                    System.out.println("You Must Write the name of the Struct or union or enum like Std_Name_s or Std_Name_u or Std_Name_e");
                }
            }
            else
            {
                System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine() + " File Name : "+ Filename);
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
            System.out.print("line: " + ctx.start.getLine()) ;
            System.out.println( " Variable : " +id + " it's type is "+ type + " and it is Local");


        }
        //Struct or union or enum
        else if(numOfBranches == 1)
        {
            String[] typeAndID = visit(declarationSpecifiers.declarationSpecifier(0).typeSpecifier());
            String id = typeAndID[1];
            int j = 0 ;
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
                            System.out.println("  and it is local");
                            for( int i = 0 ; i < Str_no_of_var[Str_no_of_var_index-1] ; i++)
                            {
                                System.out.print("Struct " + id + " content : ");
                                System.out.println( " Variable : " +typeAndID[i+3+j] + " it's type is "+  typeAndID[i+2+j] + " is Local");
                                j++;

                            }
                        }
                        else
                        {
                            System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine() + " File Name : "+ Filename);
                            System.out.println("You Must Write the name of the Struct like Std_Name_s");
                        }
                    }
                    else if(id.charAt(id.length() - 1) == 'u')
                    {
                        if(id.charAt(id.length() - 2) == '_' && id.charAt(3) == '_')
                        {
                            System.out.print("The Name of the union is : ");
                            System.out.print(id);
                            System.out.println("  and it is local");
                            for( int i = 0 ; i < Str_no_of_var[Str_no_of_var_index-1] ; i++)
                            {
                                System.out.print("Union " + id + " content : ");
                                System.out.println( " Variable : " +typeAndID[i+3+j] + " it's type is "+  typeAndID[i+2+j] + " is Local");
                                j++;

                            }
                        }
                        else
                        {
                            System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine() + " File Name : "+ Filename);
                            System.out.println("You Must Write the name of the Union like Std_Name_u");
                        }
                    }
                    else if (id.charAt(id.length() - 1) == 'e')
                    {
                        if(id.charAt(id.length() - 2) == '_' && id.charAt(3) == '_')
                        {
                            System.out.print("The Name of the Enum is : ");
                            System.out.print(id);
                            System.out.println("  and it is local");
                            int index = 2;
                            for( int i = 0 ; i < Str_no_of_var[Str_no_of_var_index-1] ; i++)
                            {
                                System.out.print("Enum " + id + " content : ");
                                System.out.println( " Variable : " +typeAndID[index] +" is Local");
                                index++;
                                j++;

                            }
                        }
                        else
                        {
                            System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine() + " File Name : "+ Filename);
                            System.out.println("You Must Write the name of the enum like Std_Name_e");
                        }
                    }
                    else
                    {
                        System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine() + " File Name : "+ Filename);
                        System.out.println("You Must Write the name of the Struct or union or enum like Std_Name_s or Std_Name_u or Std_Name_e");
                    }
                }
                else
                {
                    System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine() + " File Name : "+ Filename);
                    System.out.println("You Must Write the name of the Struct or union or enum like Std_Name_s or Std_Name_u or Std_Name_e");
                }
            }
            else
            {
                System.out.println("error :" + ctx.getText() + " in line: " + ctx.start.getLine() + " File Name : "+ Filename);
                System.out.println("You Must Write the name of the Struct or union or enum like Std_Name_s or Std_Name_u or Std_Name_e");
            }

        }

        String[] s = {ctx.getText()};
        return s;
    }
    @Override public String[] visitTypeSpecifierStructOrUnion(CParser.TypeSpecifierStructOrUnionContext ctx) {
        String type = ctx.structOrUnionSpecifier().structOrUnion().getText();
        String id = ctx.structOrUnionSpecifier().Identifier().getText();
        String typeAndName[]= {"","","","","","","","","","","",""}  ;
        typeAndName[0] = type ;
        typeAndName[1] = id ;
        int index = 2 ;
        CParser.StructDeclarationListContext x =  ctx.structOrUnionSpecifier().structDeclarationList();
        Str_no_of_var[Str_no_of_var_index]  = x.getChildCount();
        Str_no_of_var_index++;
        for ( int i = 0 ; i < x.getChildCount() ; i++)
        {
            switch (i)
            {
                case 0:
                    typeAndName[index] = ctx.structOrUnionSpecifier().structDeclarationList().structDeclaration(0).specifierQualifierList().typeSpecifier().getText();
                    index++;
                    typeAndName[index] = ctx.structOrUnionSpecifier().structDeclarationList().structDeclaration(0).specifierQualifierList().specifierQualifierList().typeSpecifier().getText();
                    index++;
                     break;
                case 1:
                    typeAndName[index] = ctx.structOrUnionSpecifier().structDeclarationList().structDeclaration(1).specifierQualifierList().typeSpecifier().getText();
                    index++;
                    typeAndName[index] = ctx.structOrUnionSpecifier().structDeclarationList().structDeclaration(1).specifierQualifierList().specifierQualifierList().typeSpecifier().getText();
                    index++;
                    break;
                case 2:
                    typeAndName[index] = ctx.structOrUnionSpecifier().structDeclarationList().structDeclaration(2).specifierQualifierList().typeSpecifier().getText();
                    index++;
                    typeAndName[index] = ctx.structOrUnionSpecifier().structDeclarationList().structDeclaration(2).specifierQualifierList().specifierQualifierList().typeSpecifier().getText();
                    index++;
                    break;
                case 3:
                    typeAndName[index] = ctx.structOrUnionSpecifier().structDeclarationList().structDeclaration(3).specifierQualifierList().typeSpecifier().getText();
                    index++;
                    typeAndName[index] = ctx.structOrUnionSpecifier().structDeclarationList().structDeclaration(3).specifierQualifierList().specifierQualifierList().typeSpecifier().getText();
                    index++;
                    break;

            }

        }

        return typeAndName;
    }
    @Override public String[] visitTypeSpecifierEnum(CParser.TypeSpecifierEnumContext ctx) {

        String type = ctx.enumSpecifier().Enum().getText();
        String id = ctx.enumSpecifier().Identifier().getText();
        String typeAndName[]= {"","","","","","","","","","","",""}  ;
        typeAndName[0] = type ;
        typeAndName[1] = id ;
        int index = 2 ;
        CParser.EnumeratorListContext x =  ctx.enumSpecifier().enumeratorList();
        Str_no_of_var[Str_no_of_var_index]  = x.getChildCount() - (x.getChildCount()/2);
        Str_no_of_var_index++;
        for ( int i = 0 ; i < x.getChildCount() ; i++)
        {
            switch (i) {
                case 0:
                    typeAndName[index] = ctx.enumSpecifier().enumeratorList().enumerator(0).enumerationConstant().Identifier().getText();
                    index++;
                    break;
                case 1:
                    typeAndName[index] = ctx.enumSpecifier().enumeratorList().enumerator(1).enumerationConstant().Identifier().getText();
                    index++;
                    break;
                case 2:
                    typeAndName[index] = ctx.enumSpecifier().enumeratorList().enumerator(2).enumerationConstant().Identifier().getText();
                    index++;
                    break;
                    /*
                case 3:
                    typeAndName[index] = ctx.enumSpecifier().enumeratorList().enumerator(3).enumerationConstant().Identifier().getText();
                    index++;
                    break;
                case 4:
                    typeAndName[index] = ctx.enumSpecifier().enumeratorList().enumerator(4).enumerationConstant().Identifier().getText();
                    index++;
                    break;
                case 5:
                    typeAndName[index] = ctx.enumSpecifier().enumeratorList().enumerator(5).enumerationConstant().Identifier().getText();
                    index++;
                    break;

                     */
            }
        }

        return typeAndName ;
    }
    /*
    @Override public String[] visitFunctionDefinition(CParser.FunctionDefinitionContext ctx)
    {
        String type = ctx.declarationSpecifiers().declarationSpecifier(2).typeSpecifier().getText().;
        String id   = ctx.declarator().directDeclarator().Identifier().getText();
        System.out.print("line: " + ctx.start.getLine() +ctx.declarationSpecifiers().declarationSpecifier(2).typeSpecifier().getText());
        System.out.println( " Function name is : " +id + " it's type is "+ type );

        String[] typeAndId = {type,id };
        return typeAndId ;
    }
    */


}
