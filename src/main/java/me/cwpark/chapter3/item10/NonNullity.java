package me.cwpark.chapter3.item10;

/*
 * Non-nullity
 * All objects must be unequal to null
 */
public class NonNullity {

    @Override public boolean equals(Object o) {
        // if (o == null) return false; // This test is unnecessary

        // instanceof operator is specified to return false if its first operand is null
        if (!(o instanceof NonNullity))
            return false;
        NonNullity n = (NonNullity) o;

        //....
        return true;
    }
}
