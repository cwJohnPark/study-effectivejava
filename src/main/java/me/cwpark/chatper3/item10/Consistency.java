package me.cwpark.chatper3.item10;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * If two objects are equal, they must remain equal for all time unless one of them is modified
 *
 * To avoid this sort of problem,
 *  equals methods should perform only deterministic computations on memory-resident objects
 */
public class Consistency {
    public static void main(String[] args) throws MalformedURLException {

        /*
         * Translating a host name to an IP address can require network access,
         * and it isn't guaranteed to yield the same results over time.
         */
        URL url = new URL("http://", "somehostname", 80, "/");

    }
}
