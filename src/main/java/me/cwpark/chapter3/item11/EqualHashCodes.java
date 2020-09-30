package me.cwpark.chapter3.item11;

import java.util.HashMap;
import java.util.Map;

/*
 * Equal objects must have equal hash codes
 */
class EqualHashCodes {

    // Object's hashCode method returns two seemingly random numbers
    // instead of two equal numbers
    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");

        // It returns null
        m.get(new PhoneNumber(707, 867, 5309));
    }
}

final class PhoneNumber { // final class
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return areaCode == pn.areaCode &&
                prefix == pn.prefix &&
                lineNum == pn.lineNum;
    }

}

