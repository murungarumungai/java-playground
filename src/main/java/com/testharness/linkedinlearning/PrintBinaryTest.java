package com.testharness.linkedinlearning;

import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryTest {

    public static void printBinary(int n) {
        if (n <= 0) {
            System.out.println("Nothing to print");
            return;
        }
        /*printBinary(n / 2);
        System.out.print(n % 2);*/

        for (int i = 0; i <= n; i++) {
            System.out.println(Integer.toBinaryString(i));
        }
        System.out.println();
    }

    public static void printBinaryUsingQueue(int n) {

        if (n <= 0) {
            System.out.println("Nothing to print");
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        for (int i = 1; i <= n; i++) {
            Integer current = queue.remove();

            System.out.println(current);
            queue.add(current * 10);
            queue.add(current * 10 + 1);

        }

        System.out.println();

    }

    public static void main(String[] args) {
        printBinary(6);

        printBinaryUsingQueue(6);
    }
}
