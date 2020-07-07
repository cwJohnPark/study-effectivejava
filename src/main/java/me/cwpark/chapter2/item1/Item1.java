package me.cwpark.chapter2.item1;

/**
 * Item1 : Consider static factory methods instead of constructors
 */
public class Item1 {

    public static void main(String[] args) {

    }

    /**
     * boolean 원시 값을 Boolean 참조 객체로 변환
     */
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
}
