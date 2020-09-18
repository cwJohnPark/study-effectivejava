package me.cwpark.chapter2.item5;

import java.util.function.Supplier;

public class LexiconFactory implements Supplier<Lexicon> {

    @Override
    public Lexicon get() {
        return new Lexicon();
    }
}
