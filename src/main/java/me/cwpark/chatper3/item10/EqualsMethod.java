package me.cwpark.chatper3.item10;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

/*
 * Item 10: Object the general contract when overriding equals
 */
public class EqualsMethod {

    // Avoid problems is not to override the equals method
    public static void main(String[] args) {

        /*
         * Each instance of the class is inherently unique
         * (eg. thread)
         */
        Thread t = new Thread(() -> {
            System.out.println("This thread is inherently unique by Object class.");
        });

        /*
         * Don't implement equals to check logical equality
         * Are these two pattern objects same?
         */
        Pattern pattern = Pattern.compile("\\s");
        Pattern pattern2 = Pattern.compile("\\s");

        /*
         * A superclass has already overridden equals.
         * Set inherits from AbstractSet
         */
        Set<Integer> set = new HashSet<>();

        /*
         * A private or package-private class doesn't need to override equals.
         */
        final class SomeImmutable {
            @Override public boolean equals(Object o) {
                throw new AssertionError(); // Method is never called.
            }
        }

    }
}
