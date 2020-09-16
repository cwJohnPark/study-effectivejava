package me.cwpark.chapter2.item3;

/**
 * item3: Enforce the singleton property with a private constructor or an enum type
 */
public class ElvisPublicFinalField {
    /*
     * Singleton with public final field
     * A Caveat: a privileged client can invoke the private constructor reflectively
     *   with the aid of the AccessibleObject.setAccessible method.
     */
    public static final ElvisPublicFinalField INSTANCE = new ElvisPublicFinalField();

    private ElvisPublicFinalField() {
    }
    public void leaveTheBuilding() {
    }
}
