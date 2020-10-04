package me.cwpark.chapter3.item13;

/*
 * The general contract for the clone method is weak.
 */
public class GeneralClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        X x = new X();
        boolean isCloneSame = x != x.clone();
        System.out.println(isCloneSame); // true

        boolean isTypeEqual = x.clone().getClass() == x.getClass();
        System.out.println(isTypeEqual); //true, not an absolute requirement

        boolean equals = x.clone().equals(x); // true, not an absolute requirement
        System.out.println(equals);

    }


}

class X implements Cloneable {
    private int field1;
    private String field2;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}