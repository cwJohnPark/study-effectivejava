package me.cwpark.chapter3.item12;

/*
 * Document you intentions,
 *  even if you don't decide to specify the format
 */
public final class PhoneNumber {
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

    /**
     *  Returns the string representation of this phone number.
     *  The string consists of twelve characters whose format is
     *  "XXX-YYY-ZZZZ", where XXX is the area code, YYY is the
     *  prefix, and ZZZZ is the line number. Each of the capital letters
     *  represent a single decimal digit.
     */
    @Override public String toString() {
        return "PhoneNumber{" +
                "areaCode=" + areaCode +
                ", prefix=" + prefix +
                ", lineNum=" + lineNum +
                '}';
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

    @Override public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }


}
