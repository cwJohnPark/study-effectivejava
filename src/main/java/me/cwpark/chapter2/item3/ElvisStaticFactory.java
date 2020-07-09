package me.cwpark.chapter2.item3;

/**
 * Singleton with static factory
 */
public class ElvisStaticFactory {
    private static final ElvisStaticFactory INSTANCE = new ElvisStaticFactory();

    private ElvisStaticFactory() {
    }

    public static ElvisStaticFactory getInstance() { return INSTANCE; }

    public void leaveTheBuilding() {
    }
}
