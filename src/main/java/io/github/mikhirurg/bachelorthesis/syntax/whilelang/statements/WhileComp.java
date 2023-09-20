package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

public class WhileComp implements WhileStatement {

    private final WhileStatement statement1;

    private final WhileStatement statement2;

    public WhileComp(WhileStatement statement1, WhileStatement statement2) {
        this.statement1 = statement1;
        this.statement2 = statement2;
    }

    public WhileStatement getStatement1() {
        return statement1;
    }

    public WhileStatement getStatement2() {
        return statement2;
    }

    @Override
    public String textRepresentation() {
        return statement1.textRepresentation() + ";\n" + statement2.textRepresentation();
    }

}
