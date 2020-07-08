package me.cwpark.chapter2.item3;

/**
 * item3: Enforce the singleton property with a private constructor or an enum type
 */
public class ElvisPublicFinalField {
    // Singleton with public final field
    public static final ElvisPublicFinalField INSTNACE = new ElvisPublicFinalField();

    private ElvisPublicFinalField() {
    }
    public void leaveTheBuilding() {
    }
}
