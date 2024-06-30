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

/**
 * ProgramBuilder is a class that allows constructing the class representation of the While++ program.
 */
public class ProgramBuilder {

    /**
     * The method allows creating a class representation of the string representation of the While++ program.
     * @param program the program that is transformed into the class representation
     * @return the class representation of given While++ program
     */
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

    /**
     * The method allows reading the While++ program from the file and transforming it to the class representation.
     * @param file the file containing the input While++ program
     * @return the class representation of the given While++ program
     * @throws IOException if there is a problem with the input file
     */
    public static WhileStatement parseProgram(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line).append("\n");
        }

        return parseProgram(builder.toString());
    }
}
