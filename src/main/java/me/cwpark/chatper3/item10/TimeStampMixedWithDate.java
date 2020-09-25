package me.cwpark.chatper3.item10;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeStampMixedWithDate {
    public static void main(String[] args) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = new Date();

        List<Date> dates = new ArrayList<>();

        // WRONG! Do not use Timestamp and Date objects in the same collection
        dates.add(ts);
        dates.add(date);
    }
}
