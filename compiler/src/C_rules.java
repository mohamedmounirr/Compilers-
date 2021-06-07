import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;

/**
 *  @brief <b>CBaseVisitor</b>
 *  Extended class from CBaseVisitor class
 *  @return Stringe[] which is the name of the struct or union or enum
 *  @details
 */
public class C_rules extends CBaseVisitor<String[] >
{
    JSONObject declareObject = new JSONObject();
    JSONObject globalObject = new JSONObject();
    JSONObject localObject = new JSONObject();
    FileReader Filename ;
    public C_rules(JSONObject declareObject, JSONObject globalObject, JSONObject localObject , FileReader m )
    {
        this.declareObject = declareObject;
        this.globalObject = globalObject;
        this.localObject = localObject;
        Filename = m ;

    }
    /*int [] Str_no_of_var = {0,0,0,0,0,0,0,0};
    int [] Enum_no_of_var = {0,0,0,0,0,0,0,0};
    int Str_no_of_var_index = 0 ;
    int enum_no_of_var_index = 0 ;*/
    /*public C_rules(String m)
    {
        Filename = m ;
    }*/

    /**
     *  @brief <b>visitGlobalDeclaration</b>
     *  The global decleration get inside
     *  @param ctx GlobalDeclarationContext
     *  @return Stringe[] which is the name of the struct or union or enum
     *  @details
     */
    //externalDdeclaration: declaration
    @Override public String[] visitGlobalDeclaration(CParser.GlobalDeclarationContext ctx) {
        //System.out.println("Global declaration " + ctx.getText() + " in line: " + ctx.start.getLine());
        CParser.DeclarationSpecifiersContext declarationSpecifiers = ctx.declaration().declarationSpecifiers();
        int numOfdeclarationSpecifiers = declarationSpecifiers.getChildCount();

        //Global variable
        if (numOfdeclarationSpecifiers == 2) {
            String type = declarationSpecifiers.declarationSpecifier(0).getText();
            String id = declarationSpecifiers.declarationSpecifier(1).getText();

            if (type.length() > 4 && type.substring(0, 4).equals("enum") && !id.matches((String) globalObject.get("enum")))
            {
                System.out.println("Line " + ctx.start.getLine() + ": Enum " + type.substring(4) + " \"" + id + "\" should follow the pattern: " + (String) globalObject.get("enum"));
            }
            else if (type.length() > 5 && type.substring(0, 5).equals("union") && !id.matches((String) globalObject.get("union")))
            {
                System.out.println("Line " + ctx.start.getLine() + ": Union " + type.substring(5) + " \"" + id + "\" should follow the pattern: " + (String) globalObject.get("union"));
            }
            else if (type.length() > 6 && type.substring(0, 6).equals("struct") && !id.matches((String) globalObject.get("struct")))
            {
                System.out.println("Line " + ctx.start.getLine() + ": Struct " + type.substring(6) + " \"" + id + "\" should follow the pattern: " + (String) globalObject.get("struct"));
            }
            else if (!id.matches((String) globalObject.get("other")))
            {
                System.out.println("Line " + ctx.start.getLine() + ": " + type + " \"" + id + "\" should follow the pattern: " + (String) globalObject.get("other"));
            }
            //System.out.println("Global, type: " + type + ", id: " + id);

        }
        //Struct, union or enum declaration
        else if (numOfdeclarationSpecifiers == 1)
        {
            String[] typeAndID = visit(declarationSpecifiers.declarationSpecifier(0).typeSpecifier());
            //System.out.println("Data structure, type: " + typeAndID[0] + ", id: " + typeAndID[1]);
            if (!typeAndID[1].matches((String) declareObject.get(typeAndID[0])))
            {
                System.out.println("Line " + ctx.start.getLine() + ": " + typeAndID[0] + " \"" + typeAndID[1] + "\" should follow the pattern: " + (String) declareObject.get(typeAndID[0]));
            }
        }
        String[] s = {ctx.getText()};
        return s;
    }

    /**
     *  @brief <b>visitGlobalDeclaration</b>
     *  The Local decleration get inside
     *  @param ctx LocalDeclarationContext
     *  @return Stringe[] which is the name of the struct or union or enum
     *  @details
     */
    @Override public String[] visitLocalDeclaration(CParser.LocalDeclarationContext ctx)
    {
        //System.out.println("Local declaration " + ctx.getText() + " in line: " + ctx.start.getLine());
        CParser.DeclarationSpecifiersContext declarationSpecifiers = ctx.declaration().declarationSpecifiers();
        int numOfdeclarationSpecifiers = declarationSpecifiers.getChildCount();


        if(numOfdeclarationSpecifiers == 2){
            String type = declarationSpecifiers.declarationSpecifier(0).getText();
            String id = declarationSpecifiers.declarationSpecifier(1).getText();

            if(type.length() > 4 && type.substring(0,4).equals("enum") && !id.matches((String) localObject.get("enum")))
            {
                System.out.println("Line " + ctx.start.getLine() + ": Enum " + type.substring(4) + " \"" + id + "\" should follow the pattern: " + (String) localObject.get("enum"));
            }
            else if(type.length() > 5 && type.substring(0,5).equals("union") && !id.matches((String) localObject.get("union")))
            {
                System.out.println("Line " + ctx.start.getLine() + ": Union " + type.substring(5) + " \"" + id + "\" should follow the pattern: " + (String) localObject.get("union"));
            }
            else if(type.length() > 6 && type.substring(0,6).equals("struct") && !id.matches((String) localObject.get("struct")))
            {
                System.out.println("Line " + ctx.start.getLine() + ": Struct " + type.substring(6) + " \"" + id + "\" should follow the pattern: " + (String) localObject.get("struct"));
            }
            else if(!id.matches((String) localObject.get("other")))
            {
                System.out.println("Line " + ctx.start.getLine() + ": " + type + " \"" + id + "\" should follow the pattern: " + (String) localObject.get("other"));
            }
            //System.out.println("local, type: " + type + ", id: " + id);
        }
        else if (numOfdeclarationSpecifiers == 1)
        {
            String[] typeAndID = visit(declarationSpecifiers.declarationSpecifier(0).typeSpecifier());
            //System.out.println("Data structure, type: " + typeAndID[0] + ", id: " + typeAndID[1]);
            if (!typeAndID[1].matches((String) declareObject.get(typeAndID[0])))
            {
                System.out.println("Line " + ctx.start.getLine() + ": " + typeAndID[0] + " \"" + typeAndID[1] + "\" should follow the pattern: " + (String) declareObject.get(typeAndID[0]));
            }
        }

        /*else if(numOfBranches == 1)
        {
            String[] typeAndID = visit(declarationSpecifiers.declarationSpecifier(0).typeSpecifier());
            String id = typeAndID[1];
            int j = 0 ;
            System.out.println( "Variable " +typeAndID[2] + " it's type is "+ typeAndID[3] + " is Local");
           if(id.length() > 6)
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

        }*/

        String[] s = {ctx.getText()};
        return s;
    }
    /**
     *  @brief <b>visitGlobalDeclaration</b>
     *  The global or local decleration of struct or union get inside
     *  @param ctx TypeSpecifierStructOrUnionContext
     *  @return Stringe[] which is the name of the struct or union or enum
     *  @details
     */

    @Override public String[] visitTypeSpecifierStructOrUnion(CParser.TypeSpecifierStructOrUnionContext ctx)
    {
        String type = ctx.structOrUnionSpecifier().structOrUnion().getText();
        String id = ctx.structOrUnionSpecifier().Identifier().getText();
        String[] typeAndName = {type,id};

        return typeAndName;
    }
    /**
     *  @brief <b>visitGlobalDeclaration</b>
     *  The global or local decleration or enum get inside
     *  @param ctx TypeSpecifierEnumContext
     *  @return Stringe[] which is the name of the struct or union or enum
     *  @details
     */
    @Override public String[] visitTypeSpecifierEnum(CParser.TypeSpecifierEnumContext ctx)
    {
        String type = ctx.enumSpecifier().Enum().getText();
        String id = ctx.enumSpecifier().Identifier().getText();

        String[] typeAndName = {type,id};
        return typeAndName;
    }

    //function
    @Override
    public String[] visitExternalFunctionDefinition(CParser.ExternalFunctionDefinitionContext ctx) {

        String type = ctx.functionDefinition().declarationSpecifiers().declarationSpecifier(0).getText();
        String id = ctx.functionDefinition().declarator().directDeclarator().directDeclarator().getText();

        //System.out.println("function, return type: "+ type + ", id:" + id);

        if(!id.matches((String) declareObject.get("api"))){
            System.out.println("Line " + ctx.start.getLine() + ": Function \"" + id + "\" should follow the pattern: " + (String) declareObject.get("api"));
        }


        visitChildren(ctx);

        String[] s = {ctx.getText()};
        return s;
    }

    //function parameters
    @Override
    public String[] visitParameterDeclaration(CParser.ParameterDeclarationContext ctx) {

        String type = ctx.declarationSpecifiers().declarationSpecifier(0).getText();
        String id = ctx.declarator().getText();

        //System.out.println("Function parameter, type: " + type + ", id:" + id);

        String[] s = {ctx.getText()};
        return s;
    }


}
