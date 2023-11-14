grammar While;

prog: stm + EOF;

stm: TYPE VAR ':=' expr
    | VAR ':=' expr
    | 'skip'
    | 'printInt' '(' aexp ')'
    | 'printString' '(' strexpr ')'
    | 'printBool' '(' bexp ')'
    | 'readInt' '(' VAR ')'
    | 'readString' '(' VAR ')'
    | 'readBool' '(' VAR ')'
    | 'if' bexp 'then' branchOne 'else' branchTwo
    | 'while' bexp 'do' stm
    | '(' stm ')'
    | stm ';' stm
    ;

branchOne : stm ;

branchTwo : stm ;

aexp: aexp MULT aexp
    | aexp (MINUS | PLUS) aexp
    | atom
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

PLUS: '+' ;
MINUS: '-';
MULT: '*';

NOT: 'not' ;
AND: 'and' ;
OR: 'or' ;

VAR: [a-zA-Z]+ ;

WS: [ \t\n]+ -> skip ;