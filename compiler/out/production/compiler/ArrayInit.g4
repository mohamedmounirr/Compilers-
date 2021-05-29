grammar ArrayInit;
arrayinit : '{' list? '}' ;

list : (obj ',' list)
    |
    obj;


obj : NUM
     | arrayinit
     ;
NUM  : [0-9]+;
WS : [ \t\r\n]+ ->skip;
