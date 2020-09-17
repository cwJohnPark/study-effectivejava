package me.cwpark.chapter2.item4;

/**
 * item4: Enforce noninstantiability with a private constructor
 */
public class UtilityClass {

   /*
    * Suppress default constructor for noninstantiability
    */
   private UtilityClass() {
       throw new AssertionError();
   }
}
