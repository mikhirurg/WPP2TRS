package io.github.mikhirurg.bachelorthesis.trs;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.*;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print.WhilePrint;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileBoolVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileIntVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileStringVar;

import java.util.*;

public class TRSPrinter {
    private static class State {
        private final Map<WhileIntVar, Integer> integerVars;
        private final Map<WhileBoolVar, Integer> booleanVars;
        private final Map<WhileStringVar, Integer> stringVars;

        private final List<String> out;

        private final List<String> in;

        public State() {
            this.integerVars = new HashMap<>();
            this.booleanVars = new HashMap<>();
            this.stringVars = new HashMap<>();
            this.out = new ArrayList<>();
            this.in = new ArrayList<>();
        }

        public Map<WhileIntVar, Integer> getIntegerVars() {
            return integerVars;
        }

        public Map<WhileBoolVar, Integer> getBooleanVars() {
            return booleanVars;
        }

        public Map<WhileStringVar, Integer> getStringVars() {
            return stringVars;
        }

        public List<String> getOut() {
            return out;
        }

        public List<String> getIn() {
            return in;
        }
    }

    public static class Pair<U, V> {
        private final U first;
        private final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        public U getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }
    }

    private State state;

    private List<Pair<Integer, TRSRule>> trs;

    public void visitAssignment(WhileAssignment assignment) {

    }

    public void visitComp(WhileComp comp) {

    }

    public void visitIf(WhileIf whileIf) {

    }

    public void visitSkip(WhileSkip skip) {

    }

    public void visitDeclaration(WhileVarDeclaration declaration) {

    }

    public void visitWhile(WhileWhile whileWhile) {

    }

    public void visitIntPrint(WhilePrint whilePrint) {

    }

    public void visitBoolPrint(WhilePrint whilePrint) {

    }

    public void visitStringPrint(WhilePrint whilePrint) {

    }
}
