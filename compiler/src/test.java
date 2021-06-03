import java.io.FileInputStream;
import org.antlr.v4.runtime.* ;
import org.antlr.v4.runtime.tree.*;

public class test {
    public static void main(String[] args) throws Exception
    {
        String inputFile = "main.expr";
        FileInputStream is = new FileInputStream(inputFile) ;
        ANTLRInputStream input = new ANTLRInputStream(is);
        CLexer lexer = new CLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CParser parser = new CParser(tokens);
        //ParseTree tree = parser.structOrUnionSpecifier();
        ParseTree tree1 = parser.compilationUnit();
        //String m = {"t",".","expr"};
        C_rules cv = new C_rules(inputFile);

        //cv.visit(tree);
        cv.visit(tree1);



        //ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        //parseTreeWalker.walk(new C_rules() , tree);
    }

}