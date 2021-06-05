# Compilers-
C_rules (JSONObject declareObject, JSONObject globalObject, JSONObject localObject, FileReader m)
 
String[] 	visitGlobalDeclaration (CParser.GlobalDeclarationContext ctx)
 	visitGlobalDeclaration The global decleration get inside More...
 
String[] 	visitLocalDeclaration (CParser.LocalDeclarationContext ctx)
 	visitGlobalDeclaration The Local decleration get inside More...
 
String[] 	visitTypeSpecifierStructOrUnion (CParser.TypeSpecifierStructOrUnionContext ctx)
 	visitGlobalDeclaration The global or local decleration of struct or union get inside More...
 
String[] 	visitTypeSpecifierEnum (CParser.TypeSpecifierEnumContext ctx)
 	visitGlobalDeclaration The global or local decleration or enum get inside More...
 
String[] 	visitExternalFunctionDefinition (CParser.ExternalFunctionDefinitionContext ctx)
 	visitGlobalDeclaration The global decleration get inside More...
 
String[] 	visitParameterDeclaration (CParser.ParameterDeclarationContext ctx)
 	visitGlobalDeclaration The global decleration get inside More...
