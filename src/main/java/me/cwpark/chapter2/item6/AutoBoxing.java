package me.cwpark.chapter2.item6;

/*
 * Prefer primitives to boxed primitives, and watch out for unintentional autoboxing.
 */
public class AutoBoxing {

    /*
     * Hideously slow!
     */
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i; // create 2^31 unnecessary Long instances.
        }
        return sum;
    }
}
