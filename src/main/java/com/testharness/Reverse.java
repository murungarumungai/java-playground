package com.testharness;

import java.util.*;

public class Reverse {

    public static void main(String[] args) {

        Reverse reverse = new Reverse();
        reverse.reverse(new int[]{1,2,3,4,5}); //time complexity O(N)

        Set<Integer> set = new TreeSet<Integer>();

        set.add(3);
        set.add((int) 3.0);

        System.out.println(set);

        Collection<String> collection;
        collection = new ArrayDeque<>();
        collection.add("");

    }

    void reverse(int[] array) {

        for (int i = 0; i < array.length/2; i++) {
            int lastElementIndex = array.length - i - 1;
            int temp = array[i];

            array[i] = array[lastElementIndex];
            array[lastElementIndex] = temp;
        }

        System.out.println(Arrays.toString(array));

    }
}


