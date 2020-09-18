package me.cwpark.chapter2.item5;

import java.util.List;

/*
 * In appropriate use of singleton - inflexible & untestable
 */
public class SpellCheckerSingleton {
    // What if I want to use different dictionaries?
    private static final Lexicon dictionary = new Lexicon();

    // Noninstantiable
    private SpellCheckerSingleton() {}

    public static boolean isValid(String word) {
        return false;
    }

    public static List<String> suggestions(String typo) {
        return null;
    }

    /*
     * Non final and setter method
     * Inappropriate for classes whose behavior is parameterized by an underlying resource.
     */
    private static Lexicon dictionary2 = new Lexicon();

    public static void setDictionary2(Lexicon dictionary2) {
        SpellCheckerSingleton.dictionary2 = dictionary2;
    }
}
