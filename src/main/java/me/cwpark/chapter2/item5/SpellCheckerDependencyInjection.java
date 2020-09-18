package me.cwpark.chapter2.item5;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/*
 * Dependency injection provides flexibility and testability
 */
public class SpellCheckerDependencyInjection {

    // client code
    public static void main(String[] args) {
        SpellCheckerDependencyInjection spellChecker = new SpellCheckerDependencyInjection(new LexiconFactory());

    }

    private final Lexicon dictionary;

    public SpellCheckerDependencyInjection(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    /*
     * Dependency Injection is applicable to factory method
     * Constraint the factory's type parameter using a bounded wildcard type [Gamma95]
     */
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
