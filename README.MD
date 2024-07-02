# WPP2TRS

## Project description

WPP2TRS is the Java implementation of the translation process that allows converting While++ programs into the Logically Constrained Term Rewriting Systems.

The project is developed as a practical part of the Bachelor's thesis in Computing Science at Radboud University Nijmegen.

## Installation guide

The project requires Java version 21 with preview features enabled.

There are a few different ways how a user can obtain the jar file to execute the project:
- The latest stable version of the project is available in the [Releases](https://github.com/mikhirurg/WPP2TRS/releases) section of the repository
- The user can build the executable jar from sources by using the script ```build.sh```

After obtaining the executable jar, the user can just run the following command:

```shell
java --enable-preview -jar wpp2trs-1.0-SNAPSHOT-standalone.jar
```

## How to use the project

To run the project the user first need to specify the path to the While++ source file as the first argument:

```shell
java --enable-preview -jar wpp2trs-1.0-SNAPSHOT-standalone.jar program.wpp
```

After that user can specify the run option to process the input While++ source file:

<table>
    <tr> 
        <td> Option </td> <td> Description </td>
    </tr>
    <tr>
        <td> --printlctrs </td> <td> Prints the LCTRS generated for the input While++ program </td>
    </tr>
    <tr>
        <td> --exec </td> <td> Executes the LCTRS generated for the input While++ program using <a href="https://github.com/hezzel/cora">Cora</a> rewriting engine </td>
    </tr>
    <tr>
        <td> --explicit </td> <td> Shows every reduction step in the LCTRS during the LCTRS execution </td>
    </tr>
    <tr>
        <td> --provetermination </td> <td> Attempts to prove the termination of the input While++ program using <a href="https://github.com/hezzel/cora">Cora</a>) constrained rewriting analyzer library </td>
    </tr>
</table>

## Examples

### Printing the LCTRS for the input program
#### Input program "program.wpp":
```
int x := 0;
while x < 10 do (
    x := x + 1
)
```

#### Command:
```
java --enable-preview -jar wpp2trs-1.0-SNAPSHOT-standalone.jar program.wpp --printlctrs
```

#### WPP2TRS output:
```
nil :: list
consI :: Int -> list -> list
consB :: Bool -> list -> list
consS :: String -> list -> list

headI :: list -> Int
headB :: list -> Bool
headS :: list -> String

tailI :: list -> list
tailB :: list -> list
tailS :: list -> list

headI(consI(i, l)) -> i
headB(consB(b, l)) -> b
headS(consS(str, l)) -> str

tailI(consI(i, l)) -> l
tailB(consB(b, l)) -> l
tailS(consS(str, l)) -> l

stm_1 :: list -> list -> list
stm_2 :: list -> list -> Int -> list
stm_3 :: list -> list -> Int -> list
stm_4 :: list -> list -> Int -> list
stm_5 :: list -> list -> Int -> list
stm_6 :: list -> list -> Int -> list

stm_1(in, out) -> stm_2(in, out, 0) | true
stm_2(in, out, x) -> stm_3(in, out, x) | true
stm_3(in, out, x) -> stm_4(in, out, x) | (x < 10)
stm_4(in, out, x) -> stm_5(in, out, (x + 1)) | true
stm_5(in, out, x) -> stm_3(in, out, x) | true
stm_3(in, out, x) -> stm_6(in, out, x) | not((x < 10))
stm_6(in, out, x) -> out | true
```

### Executing the LCTRS translation of the input program

#### Input program "program.wpp":
```
int start := 0;
int end := 100;
int guess := 0;
while not(start = end) do (
    guess := (start + end) / 2;
    bool answer := false;
    printString("Is the number greater than ");
    printInt(guess);
    printString("? (true/false) \n");
    readBool(answer);
    if (answer) then start := guess + 1
    else end := guess
);
printString("The number is ");
printInt(guess + 1);
printString("!")
```
#### Command:
```
java --enable-preview -jar wpp2trs-1.0-SNAPSHOT-standalone.jar program.wpp --exec
```

#### WPP2TRS output:
```
Is the number greater than 50? (true/false) 
>true
Is the number greater than 75? (true/false) 
>true
Is the number greater than 88? (true/false) 
>false
Is the number greater than 82? (true/false) 
>false
Is the number greater than 79? (true/false) 
>true
Is the number greater than 81? (true/false) 
>false
Is the number greater than 80? (true/false) 
>true
The number is 81!
```

### Executing the LCTRS translation of the input program and displaying every reduction step

#### Input program "program.wpp":
```
int x := 0;
while x < 10 do (
    x := x + 1
)
```

#### Command:
```
java --enable-preview -jar wpp2trs-1.0-SNAPSHOT-standalone.jar program.wpp --exec --explicit
```

#### WPP2TRS output:
```
⇒ stm_2(nil, nil, 0)
⇒ stm_3(nil, nil, 0)
⇒ stm_4(nil, nil, 0)
⇒ stm_5(nil, nil, 0 + 1)
⇒ stm_5(nil, nil, 1)
⇒ stm_3(nil, nil, 1)
⇒ stm_4(nil, nil, 1)
⇒ stm_5(nil, nil, 1 + 1)
⇒ stm_5(nil, nil, 2)
⇒ stm_3(nil, nil, 2)
⇒ stm_4(nil, nil, 2)
⇒ stm_5(nil, nil, 2 + 1)
⇒ stm_5(nil, nil, 3)
⇒ stm_3(nil, nil, 3)
⇒ stm_4(nil, nil, 3)
⇒ stm_5(nil, nil, 3 + 1)
⇒ stm_5(nil, nil, 4)
⇒ stm_3(nil, nil, 4)
⇒ stm_4(nil, nil, 4)
⇒ stm_5(nil, nil, 4 + 1)
⇒ stm_5(nil, nil, 5)
⇒ stm_3(nil, nil, 5)
⇒ stm_4(nil, nil, 5)
⇒ stm_5(nil, nil, 5 + 1)
⇒ stm_5(nil, nil, 6)
⇒ stm_3(nil, nil, 6)
⇒ stm_4(nil, nil, 6)
⇒ stm_5(nil, nil, 6 + 1)
⇒ stm_5(nil, nil, 7)
⇒ stm_3(nil, nil, 7)
⇒ stm_4(nil, nil, 7)
⇒ stm_5(nil, nil, 7 + 1)
⇒ stm_5(nil, nil, 8)
⇒ stm_3(nil, nil, 8)
⇒ stm_4(nil, nil, 8)
⇒ stm_5(nil, nil, 8 + 1)
⇒ stm_5(nil, nil, 9)
⇒ stm_3(nil, nil, 9)
⇒ stm_4(nil, nil, 9)
⇒ stm_5(nil, nil, 9 + 1)
⇒ stm_5(nil, nil, 10)
⇒ stm_3(nil, nil, 10)
⇒ stm_6(nil, nil, 10)
⇒ nil
```