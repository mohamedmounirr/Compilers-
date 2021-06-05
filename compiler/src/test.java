import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.* ;
import org.antlr.v4.runtime.tree.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class test {
    public static void main(String[] args) throws Exception
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        JSONObject declare = new JSONObject();
        JSONObject declareObject = new JSONObject();
        JSONObject globalObject = new JSONObject();
        JSONObject localObject = new JSONObject();
        FileReader reader = new FileReader("rules.json");

        try (reader)
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            declare = (JSONObject) obj;// System.out.println(declare);
            declareObject = (JSONObject) declare.get("declare");
            globalObject = (JSONObject) declare.get("global");
            localObject = (JSONObject) declare.get("local");

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        String inputFile = "main.expr";
        FileInputStream is = new FileInputStream(inputFile) ;
        ANTLRInputStream input = new ANTLRInputStream(is);
        CLexer lexer = new CLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CParser parser = new CParser(tokens);
        ParseTree tree1 = parser.compilationUnit();
        C_rules cv = new C_rules(declareObject,globalObject,localObject,reader);
        cv.visit(tree1);
        //ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        //parseTreeWalker.walk(new C_rules() , tree);
    }

}