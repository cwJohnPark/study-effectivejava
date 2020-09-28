package me.cwpark.chatper3.item10;

import java.util.Arrays;

public class PrimitiveType {
    public static void main(String[] args) {

        // Not float or double use the == operator
        System.out.println(1 == 2);

        // object reference fields, call the equals method recursively
        float a = 1.3f;
        float b = 1.5f;
        System.out.println(Float.compare(a, b));

        double d1 = 2.3;
        double d2 = 2.5;
        System.out.println(Double.compare(d2, d1));

        // If every element in an array field is significant,
        // use one of the Arrays.equals methods
        boolean areArraysEquals = Arrays.equals(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        System.out.println(areArraysEquals);
    }
}
