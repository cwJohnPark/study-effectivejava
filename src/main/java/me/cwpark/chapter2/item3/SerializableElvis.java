package me.cwpark.chapter2.item3;

import java.io.Serializable;

/**
 * Make a singleton class that uses either of these approaches serializable.
 */
public class SerializableElvis implements Serializable {

    private static final SerializableElvis INSTANCE = new SerializableElvis();

    private SerializableElvis() {
    }

    public SerializableElvis getInstance() {
        return INSTANCE;
    }

    /*
     * readResolve,
     *  otherwise whenever serialized instance is deserialized, a new instance will be created.
     */
    private Object readResolve() {
        // Return the on true Elvis and let the garbage collector
        // take care of the Elvis impersonator.
        return INSTANCE;
    }
}
