package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.SyntaxNode;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public interface WhileStatement extends SyntaxNode {
    String toString();

    void acceptTRSPrinter(TRSPrinter trsPrinter);
}
