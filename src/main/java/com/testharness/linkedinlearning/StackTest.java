package com.testharness.linkedinlearning;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {

        Stack stacki = new Stack();
        stacki.push(1);
        stacki.push(2);
        stacki.push(3);
        stacki.push(4);

        //stacki.pop();

        System.out.println(stacki.peek());
        System.out.println(stacki.size());
        System.out.println(stacki.isEmpty());
        System.out.println(stacki.search(3));
        System.out.println(stacki.search(2));
        System.out.println(stacki.search(1));
        System.out.println(stacki);

        while(!stacki.isEmpty()) {
            int removed = (int) stacki.pop();
            System.out.println("Removed: " + removed);
        }
    }
}
