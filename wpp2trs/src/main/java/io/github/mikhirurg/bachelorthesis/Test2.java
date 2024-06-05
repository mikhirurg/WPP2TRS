package io.github.mikhirurg.bachelorthesis;

import io.github.mikhirurg.bachelorthesis.trs.TRSFunction;
import io.github.mikhirurg.bachelorthesis.trs.TRSTerm;
import io.github.mikhirurg.bachelorthesis.trs.TRSVariable;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        TRSTerm term = new TRSFunction("f", List.of(
           new TRSVariable("x", ""),
           new TRSFunction("g", List.of(new TRSVariable("y", ""), new TRSVariable("z", "")))
        ));

        System.out.println(term);
    }
}
