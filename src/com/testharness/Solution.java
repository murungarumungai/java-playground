package com.testharness;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.List;
import java.util.stream.Collectors;

class Solution {

    static final int OUT = 0;
    static final int IN = 1;

    public int countWords(String str) {

        int state = OUT;

        int wc = 0;  // word count
        int i = 0;

        str = str.replaceAll("\\s{2,}"," ");
        System.out.println("str "+ str);

        // Scan all characters one by one
        while (i < str.length()) {
            // If next character is a separator, set the
            // state as OUT
            if (str.charAt(i) == ' '
                || str.charAt(i) == '!'
                || str.charAt(i) == '?'
                || str.charAt(i) == '.')

                state = OUT;


                // If next character is not a word separator
                // and state is OUT, then set the state as IN
                // and increment word count
            else if (state == OUT) {
                state = IN;
                ++wc;
            }

            // Move to next character
            ++i;
        }
        return wc;
    }

    public  int simpleArraySum(List<Integer> ar) {
        // Write your code here

        return ar.stream().collect(Collectors.summingInt(Integer::intValue));

    }
}

