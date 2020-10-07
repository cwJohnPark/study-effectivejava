package me.cwpark.chapter3.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

/*
 * No harm to the original object
 */
public class Stack_RecursiveClone implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack_RecursiveClone() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // Clone method for class with references to mutable state
    @Override protected Object clone() {
        try {
            Stack_RecursiveClone result = (Stack_RecursiveClone) super.clone();
            // If the array's element is non-primitive type, it creates a shallow copy
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Stack_RecursiveClone stack = new Stack_RecursiveClone();
        int e = 1;
        stack.push(e);
        e += 1;

        Stack_RecursiveClone clonedStack = (Stack_RecursiveClone) stack.clone();
        int clonedElement = (int) clonedStack.pop();
        clonedElement += 1;

        // Not Equal
        System.out.println(((int)stack.pop()));
        System.out.println(clonedElement);

    }

}


