package me.cwpark.chapter2.item6;

import java.util.regex.Pattern;

/**
 *  item 6: Avoid creating unnecessary objects
 */
public class UnnecessaryObject {
    public static void main(String[] args) {
        String bad = new String("bikini"); // DON'T DO THIS !
        String better = "bikini";
    }

    // Performance can be greatly improved!
    static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" +
                " (X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    static class RomaNumerals {
        private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" +
                " (X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
        static boolean isRomanNumeral(String s) {
            return ROMAN.matcher(s).matches();
        }
    }

}
