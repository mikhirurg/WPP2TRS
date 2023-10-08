package io.github.mikhirurg.bachelorthesis;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileListener;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.gen.WhileLexer;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.gen.WhileParser;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Test {
    public static void main(String[] args) {
        String program = "int x := 1; bool y := false; string z := \"Hello World!\"; if (x = 1) then (printString(z); skip; skip) else skip";

        WhileLexer whileLexer = new WhileLexer(CharStreams.fromString(program));

        CommonTokenStream tokens = new CommonTokenStream(whileLexer);
        WhileParser parser = new WhileParser(tokens);
        ParseTree tree = parser.prog();

        WhileListener listener = new WhileListener();

        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, tree);

        WhileStatement p = listener.getProgram();

        System.out.println(p.textRepresentation());

    }
}
