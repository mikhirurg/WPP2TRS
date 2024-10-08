grammar While;

// Program statements name constants:

ASSIGN: ':=' ;
SKIP_STM: 'skip' ;
PRINT_INT_STM: 'printInt' ;
PRINT_STRING_STM: 'printString' ;
PRINT_BOOL_STM: 'printBool' ;
READ_INT_STM: 'readInt' ;
READ_STRING_STM: 'readString' ;
READ_BOOL_STM: 'readBool' ;
IF: 'if' ;
THEN: 'then' ;
ELSE: 'else' ;
WHILE: 'while' ;
DO: 'do' ;
SEMICOLON: ';' ;

// Different types name constants:

INT_TYPE: 'int' ;
BOOL_TYPE: 'bool' ;
STRING_TYPE: 'string' ;

// Arithmetic expressions names:

PLUS: '+' ;
MINUS: '-' ;
MULT: '*';
DIV: '/';
MOD: '%';

// Integer, String and Boolean constants names:

INT: [0-9]+ ;
STRING: '"' .*? '"';
TRUE: 'true' ;
FALSE: 'false' ;

// Boolean operators names:

NOT: 'not' ;
AND: 'and' ;
OR: 'or' ;

// Comparison operators names:

EQ: '=' ;
LT: '<' ;
GT: '>' ;
LE: '<=' ;
GE: '>=' ;

// Left and right parenthesis:

LPAREN: '(' ;
RPAREN: ')' ;

// Block comments:

BLOCKCOMMENT: '/*' .*? '*/' -> skip ;

// Variables names:

VAR: [a-zA-Z]+ ;

WS: [ \t\n]+ -> skip ;

// While++ program:

prog: stm EOF;

// Program statements:

stm: unaryStm | blockStm | stm SEMICOLON stm;

nestedStm: unaryStm | blockStm ;

condition: bexp ;

unaryStm: skipStm
        | declareStm
        | printIntStm
        | printStringStm
        | printBoolStm
        | readIntStm
        | readStringStm
        | readBoolStm
        | ifStm
        | whileStm
        | assignStm
        ;

skipStm: SKIP_STM ;

printIntStm: PRINT_INT_STM LPAREN aexp RPAREN ;

printStringStm: PRINT_STRING_STM LPAREN strexpr RPAREN ;

printBoolStm: PRINT_BOOL_STM LPAREN bexp RPAREN ;

readIntStm: READ_INT_STM LPAREN VAR RPAREN ;

readStringStm: READ_STRING_STM LPAREN VAR RPAREN ;

readBoolStm: READ_BOOL_STM LPAREN VAR RPAREN ;

ifStm: IF condition THEN nestedStm ELSE nestedStm ;

whileStm: WHILE condition DO nestedStm ;

blockStm: LPAREN stm RPAREN ;

declareStm: (INT_TYPE | BOOL_TYPE | STRING_TYPE) VAR ASSIGN expr ;

assignStm: VAR ASSIGN expr ;

// Expressions in general:

expr: untypedexpr | typedexpr ;

untypedexpr: VAR ;

typedexpr : strexpr | aexp | bexp ;

// Arithmetic expressions:

aexp: aexp (MULT | DIV | MOD) aexp
    | aexp (MINUS | PLUS) aexp
    | aexpatom
    ;

// Atomic expressions:

aexpatom: LPAREN aexp RPAREN
    | INT
    | VAR
    ;

// Boolean expressions:

bexp: NOT bexp
    | bexp AND bexp
    | bexp OR bexp
    | bexp EQ bexp
    | aexp (EQ | GT | LT | GE | LE) aexp
    | strexpr EQ strexpr
    | LPAREN bexp RPAREN
    | bexpatom
    ;

bexpatom: TRUE
        | FALSE
        | VAR
        ;

// String expressions:

strexpr: STRING | VAR;

