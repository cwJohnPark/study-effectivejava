package me.cwpark.chatper3.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EquivalenceRelation {

    /*
     * Reflexive: For any non-null reference value x,
     *  x.equals(x) must return true
     */
    public void reflexive() {
        String a = "some string";

        // It is hard to be violated
        assert a.equals(a);
    }

    /*
     * Symmetric: For any non-null reference values x and y
     *  x.equals(y) must return true if and only if y.equals(x) returns true
     */
    public void symmetric() {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        assert cis.equals(s); // return true

        assert s.equals(cis); // return false!!!

        // Another Caveat
        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);
        list.contains(s); // It returns false in OpenJDK implementation

        // To eliminate the problem,
        // REFACTOR the equals method into a single return statement
    }

    // Broken - violates symmetry!
    final class CaseInsensitiveString {
        private final String s;
        public CaseInsensitiveString(String s) {
            this.s = Objects.requireNonNull(s);
        }

        // Broken - violates symmetry!
        @Override public boolean equals(Object o) {
            if (o instanceof CaseInsensitiveString)
                return s.equalsIgnoreCase(
                        ((CaseInsensitiveString) o).s);

            if (o instanceof String) // One-way interoperability!
                return s.equalsIgnoreCase((String) o);
            return false;
        }
    }

    /*
     * Transitive: For any non-null reference values x,y,z
     *  if x.equals(y) returns true and y.equals(z) returns true,
     *  then x.equals(z) must return true
     */

    /*
     * Consistent: For any non-null reference values x and y,
     *  multiple invocations of x.equals(y) must consistently return true
     *  or consistently return false,
     *  provided no information used in equals comparisons is modified
     */

    /*
     * For any non-null reference value x, x.equals(null) must return false
     */

}
