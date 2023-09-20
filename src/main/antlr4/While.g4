grammar While;

prog: stm+ ;

stm: TYPE VAR ':=' expr
    | VAR ':=' expr
    | 'skip'
    | stm ';' stm
    | 'if' bexp 'then' stm 'else' stm
    | 'while' bexp 'do' stm
    | 'print(' expr ')'
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
    | strexp '=' strexp
    | NOT '(' bexp ')'
    | bexp AND bexp
    | bexp OR bexp
    | '(' bexp ')'
    ;

strexp: '"' (~('"'))+ '"' ;

expr: aexp | bexp | strexp ;

TYPE: INT_TYPE | BOOL_TYPE | STRING_TYPE ;
INT_TYPE: 'int' ;
BOOL_TYPE: 'bool' ;
STRING_TYPE: 'string' ;

VAR: [a-zA-Z]+ ;

INT: [0-9]+ ;

NOT: 'not' ;
AND: 'and' ;
OR: 'or' ;

WS: [ \t\n]+ -> skip ;