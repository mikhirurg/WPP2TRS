grammar While;

prog: stm + EOF;

stm: TYPE VAR ':=' expr
    | VAR ':=' expr
    | 'skip'
    | stm ';' stm
    | 'if' bexp 'then' stm 'else' stm
    | 'while' bexp 'do' stm
    | 'printInt(' aexp ')'
    | 'printString(' strexpr ')'
    | 'printBool(' bexp ')'
    | '(' stm ')'
    ;

aexp: multExpr (('+' | '-') multExpr)*
    ;

multExpr
    : atom ('*' atom)*
    ;

atom: INT
    | VAR
    | '(' aexp ')'
    ;

bexp: 'true'
    | 'false'
    | VAR
    | aexp '=' aexp
    | aexp '<=' aexp
    | bexp '=' bexp
    | strexpr '=' strexpr
    | NOT '(' bexp ')'
    | bexp AND bexp
    | bexp OR bexp
    | '(' bexp ')'
    ;

strexpr: STRING | VAR;

expr: strexpr | aexp | bexp ;

TYPE: INT_TYPE | BOOL_TYPE | STRING_TYPE ;
INT_TYPE: 'int' ;
BOOL_TYPE: 'bool' ;
STRING_TYPE: 'string' ;

VAR: [a-zA-Z]+ ;

INT: [0-9]+ ;

STRING: '"' .*? '"';

NOT: 'not' ;
AND: 'and' ;
OR: 'or' ;

WS: [ \t\n]+ -> skip ;