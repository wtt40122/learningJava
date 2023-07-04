// 语法文件通常以grammar关键字开头，并且与文件名同名
grammar Assign;
stat : assign;
// 一条名为assign的规则
assign : ID '=' expr ';' ;
// 语法分析器的规则必须以小写字母开头
// 词法分析器的规则必须以大写字母开头
ID : [a-z]+ ;
expr : NUMBER ;
NUMBER : [1-9][0-9]*|[0]|([0-9]+[.][0-9]+) ;
WS : [ \t\r\n]+ -> skip ;