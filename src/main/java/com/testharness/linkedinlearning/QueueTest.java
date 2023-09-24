package com.testharness.linkedinlearning;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList();

        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");

        System.out.println("Queue: " + queue);

        //see next item
        System.out.println(queue.peek());

        //traverse queue
        while(!queue.isEmpty()) {
            String item = queue.remove();
            System.out.println("Item: " + item);
        }
    }
}
