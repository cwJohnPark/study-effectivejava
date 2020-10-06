package me.cwpark.chapter3.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

/*
 * If an object contains fields that refer to mutable objects,
 *  the simple clone implementation shown earlier can be disastrous.
 */
public class Stack implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        /*
         * If the clone method merely returns super.clone(),
         * its element field will refer to the same array as the original Stack instance.
         */
        Stack stack = new Stack();
        Element element1 = new Element(1);
        Element element2 = new Element(2);
        stack.push(element1);
        stack.push(element2);

        Stack clonedStack = (Stack) stack.clone();
        Element clonedElement2 = (Element) clonedStack.pop();
        clonedElement2.a += 1; // It modify the element of the original Stack Instance

        // Equal
        System.out.println(clonedElement2.a);
        System.out.println(element2.a);
    }

    static class Element {
        int a = 0;

        public Element(int a) {
            this.a = a;
        }
    }
}
