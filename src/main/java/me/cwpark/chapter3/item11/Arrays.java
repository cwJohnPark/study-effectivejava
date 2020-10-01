package me.cwpark.chapter3.item11;

/*
 * If the field is an array, treat it as if each significant element were a separate field.
 * Compute a hash code for each significant element by applying these rules recursively,
 *  and combine the values.
 */
public class Arrays {

    private int[] someArray;

    public Arrays(int[] someArray) {
        this.someArray = someArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arrays)) {
            return false;
        }
        Arrays arrays = (Arrays) o;
        return arrays.someArray.equals(o);
    }

    @Override
    public int hashCode() {
        int result = java.util.Arrays.hashCode(someArray);
        return 31 * result + java.util.Arrays.hashCode(someArray);
    }
}
