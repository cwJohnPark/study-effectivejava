package me.cwpark.chapter2.item6;

import java.util.regex.Pattern;

/*
 *  item 6: Avoid creating unnecessary objects
 */
public class AvoidUnnecessaryObject {
    public static void main(String[] args) {

        /*
         * DON'T DO THIS !
         */
        String bad = new String("bikini");

        /*
         * Virtual machine will reused the same string literal.
         */
        String better = "bikini";

        /*
         * The constructor MUST create a new object each time it's called.
         */
        boolean badUsageBool = new Boolean("true");

        /*
         * The static factory method can reused immutable objects.
         */
        boolean betterUsageBool = Boolean.valueOf("true");
    }

    /*
     * Performance can be greatly improved!
     * NOT suitable for repeated use.
     */
    static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" +
                " (X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    /*
     * Reusing expensive object for improved performance.
     */
    static class RomaNumerals {

        private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" +
                " (X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

        static boolean isRomanNumeral(String s) {
            return ROMAN.matcher(s).matches();
        }
    }

}
