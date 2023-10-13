grammar While;

prog: stm + EOF;

stm: TYPE VAR ':=' expr
    | VAR ':=' expr
    | 'skip'
    | stm ';' stm
    | 'if' bexp 'then' stm 'else' stm
    | 'while' bexp 'do' stm
    | 'printInt' '(' aexp ')'
    | 'printString' '(' strexpr ')'
    | 'printBool' '(' bexp ')'
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
    | NOT '(' bexp ')'
    | VAR
    | aexp '=' aexp
    | aexp '<=' aexp
    | bexp '=' bexp
    | strexpr '=' strexpr
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

INT: [0-9]+ ;

STRING: '"' .*? '"';

NOT: 'not' ;
AND: 'and' ;
OR: 'or' ;

VAR: [a-zA-Z]+ ;

WS: [ \t\n]+ -> skip ;