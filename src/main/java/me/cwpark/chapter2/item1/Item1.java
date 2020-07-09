package me.cwpark.chapter2.item1;

import java.math.BigInteger;
import java.util.Random;

/**
 * Item1 : Consider static factory methods instead of constructors
 */
public class Item1 {

    public static void main(String[] args) {
        BigInteger fromStaticMethod = BigInteger.probablePrime(3, new Random());
        System.out.println(fromStaticMethod);

        BigInteger fromConstructor = new BigInteger(3, new Random());
        System.out.println(fromConstructor);
    }

    /**
     * boolean 원시 값을 Boolean 참조 객체로 변환
     */
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
}
