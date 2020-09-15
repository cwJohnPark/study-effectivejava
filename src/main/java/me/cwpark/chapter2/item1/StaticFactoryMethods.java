package me.cwpark.chapter2.item1;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Instant;
import java.util.*;

import static me.cwpark.chapter2.item1.StaticFactoryMethods.SomeEnumeration.*;

/**
 * Item1 : Consider static factory methods instead of constructors
 */
public class StaticFactoryMethods {

    public static void main(String[] args) {
        BigInteger fromStaticMethod = BigInteger.probablePrime(5, new Random());
        System.out.println(fromStaticMethod);

        BigInteger fromConstructor = new BigInteger(3, new Random());
        System.out.println(fromConstructor);
    }

    /**
     * Advantages
     * 1. they have name.
     * 2. They are not required to create a new object each time they're invoked.
     */
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE; // It doesn't make new object.
    }

    /**
     * 3. They can return an object of any subtype of their return type.
     */
    public static void createAnySubType() {
        List<Integer> list = new ArrayList<>();
        Collections.synchronizedList(list); // the return type is not instantiable.
    }

    /**
     * 4. The class of the returned object can vary from call to call as function of the input parameters.
     */
    public void enumSet() {
        // It returns an instance of one of two subclasses, depending on the size of the underlying enum type.
        // sixty-four or fewer elements? It returns RegularEnumSet.
        // sixty-five or more elements? It returns JumboEnumSet.
        EnumSet<SomeEnumeration> whatCouldItBe = EnumSet.of(A, B, C, D); // RegularEnumSet

        // Clients neither know nor care about the class of the object they get back from the factory;
        // Clients care only that it is some subclass of EnumSet.
    }

    enum SomeEnumeration {
        A, B, C, D
    }


    /**
     * 5. The class of the returned object need not exist when the class containing the method is written.
     */
    public void jdbcApi() throws SQLException {
        // 1. A service interface describes factory object that produce instances of the service interface.
        Connection conn;
        Driver someJdbcDriver = DriverManager.getDriver("some jdbc url");

        // 2. A provider registration API
        DriverManager.registerDriver(someJdbcDriver); // returns nothing

        // 3. A service access API
        Connection someJdbcConnection = DriverManager.getConnection("some jdbc url");
    }

    /**
     * limitation
     * 1. Classes without public or protected constructors cannot be subclassed.
     *  but, blessing in disguise.(Item 17, Item 18)
     *
     * 2. Hard for programmers to find it.
     */

    public void staticFactoryMethodCommonName() {
        /*
         * from: type-conversion method, takes single parameters.
         */
        Date d = Date.from(Instant.now());

        /*
         * of: Aggregation method that takes multiple parameters and returns an instance of this type that incorporates them.
         */
        Set<SomeEnumeration> faceCards = EnumSet.of(A, B, C);

        /*
         * valueOf: verbose alternative to from and of
         */
        BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);

        /*
         * instance, getInstance: returns an instance that is described by its parameters.
         */
        // StackWalker luke = StackWalker.getInstance(options);

        /*
         * create, newInstance: guarantees that each call returns a new instance.
         */
        Object newArray = Array.newInstance(Integer.class, 5);

        // getType: Like getInstance, if the factory method is in a different class.
        //FileStore fs = Files.getFileStore(somePath);

        /*
         * newType: Like newInstance, but used if the factory method is in a different class.
         */
        //BufferedReader br = Files.newBufferedReader(somePath);

        /*
         * type: An alternative to getType and newType
         */
        //List<SomeEnumeration2> someList = Collections.list(SomeEnumeration2);
    }

}
