package me.cwpark.chapter2.item5;

import java.util.List;
import java.util.function.Supplier;

// Dependency injection provides flexibility and testability
public class SpellCheckerDependencyInjection {
    private final Lexicon dictionary;

    public SpellCheckerDependencyInjection(Lexicon dictionary) {
        this.dictionary = dictionary;
    }

    // Dependency Injection is applicable to factory method
    public SpellCheckerDependencyInjection(Supplier<? extends Lexicon> lexiconFactory) {
        dictionary = lexiconFactory.get();
    }

    public boolean isValid(String word) {
        return false;
    }
    public List<String> suggestions(String typo) {
        return null;
    }




}
