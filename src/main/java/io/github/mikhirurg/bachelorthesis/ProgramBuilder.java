package io.github.mikhirurg.bachelorthesis;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileListener;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.gen.WhileLexer;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.gen.WhileParser;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;

public class ProgramBuilder {
    public static WhileStatement parseProgram(String program) {
        WhileLexer whileLexer = new WhileLexer(CharStreams.fromString(program));

        CommonTokenStream tokens = new CommonTokenStream(whileLexer);
        WhileParser parser = new WhileParser(tokens);
        ParseTree tree = parser.prog();

        WhileListener listener = new WhileListener();

        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, tree);

        return listener.getProgram();
    }

    public static WhileStatement parseProgram(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line).append(" ");
        }

        return parseProgram(builder.toString());
    }
}
