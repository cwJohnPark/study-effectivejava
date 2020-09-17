package me.cwpark.chapter2.item4;

/**
 * Making a class abstract does not work to enforce noninstantiability.
 * and misleads the user into thinking the class was designed for inheritance.
 */
public abstract class SomeAbstractClass {

}
class SomeSubClass extends SomeAbstractClass {
    // how about this?
    public SomeSubClass() {
    }
}

