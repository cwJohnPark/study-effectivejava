package me.cwpark.chapter3.item11;

/*
 * If the field is an object reference
 *  and this class's equals method compares the field by recursively invoking equals,
 *  recursively invoke hashCode on the field.
 *
 * Compute a "canonical representation" for this field
 *  and invoke hashCode on the canonical representation.
 */
public class ObjectReference {

    static class SomeNestedObject {
        private final int a;

        public SomeNestedObject(int a) {
            this.a = a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ObjectReference)) {
                return false;
            }
            SomeNestedObject nestedObject = (SomeNestedObject) o;
            return a == nestedObject.a;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(a);
        }
    }

    private SomeNestedObject someNestedObject1; // Assume a significant field
    private SomeNestedObject someNestedObject2;

    public ObjectReference(SomeNestedObject object) {
        this.someNestedObject1 = object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof  ObjectReference)) {
            return false;
        }
        ObjectReference or = (ObjectReference) o;
        return or.equals(this); // recursively call equals method
    }

    @Override
    public int hashCode() {
        int result = someNestedObject1.hashCode(); // first significant field
        int c = someNestedObject2.hashCode();
        return 31 * result + c; // recursively call hashCode method
    }
}
