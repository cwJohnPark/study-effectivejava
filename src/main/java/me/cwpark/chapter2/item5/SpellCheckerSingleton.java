package me.cwpark.chapter2.item5;

import java.util.List;

/**
 * item5: Prefer dependency injection to hardwiring resources
 */
public class SpellCheckerSingleton {
    private static final Lexicon dictionary = new Lexicon();

    // Noninstantiable
    private SpellCheckerSingleton() {}

    public static boolean isValid(String word) {
        return false;
    }

    public static List<String> suggestions(String typo) {
        return null;
    }

}
