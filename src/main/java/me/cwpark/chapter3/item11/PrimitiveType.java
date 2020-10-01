package me.cwpark.chapter3.item11;

/*
 * If the field is of a primitive type,
 *  compute Type.hashCode(f),
 *  where Type is the boxed primitive class corresponding to f's type
 */
public class PrimitiveType {
    int someField;

    public PrimitiveType(int someField) {
        this.someField = someField;
    }

    @Override public int hashCode() {
        return Integer.hashCode(someField);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrimitiveType)) {
            return false;
        }
        PrimitiveType pt = (PrimitiveType) o;
        return pt.someField == this.someField;
    }

}
