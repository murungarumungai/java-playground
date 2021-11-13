package com.testharness;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class Anagram {

    public static void main(String[] args) throws ParseException {

        //repeatedString("aab",882787);

        int[][] values = { {1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0}, {0, 0, 0, 2, 0, 0}, {0, 0, 1, 2, 4, 0} };

        int row = 0, col = 0, rowStart = 0, rowEnd = 0, colStart = 0, colEnd = 0;
        boolean rowChanged = false, colChanged = false;
        List<Integer> hourGlasses = new ArrayList<>();

        System.out.println(getHourGlassTotal(values));

        /*System.out.println("1 " + 1%2);
        System.out.println("2 " +2%2);
        System.out.println("3 " +3%2);
        System.out.println("4 " +4%2);
        System.out.println(5%2);
        System.out.println(6%2);*/

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat nf2 = NumberFormat.getInstance(Locale.CHINA);

        nf = NumberFormat.getCurrencyInstance(new Locale("en", "in"));

        nf.setMinimumFractionDigits(1);
        nf2.setCurrency(Currency.getInstance(Locale.US));
        //nf.setCurrency(Currency.getInstance(new Locale("en","US")));
        String us = nf.format(12324.134);
        String us2 = nf2.format(12324.134);

        System.out.println("us " + us);
        System.out.println("us2 " + us2);

        List<String> text = new ArrayList<>();
        text.add("code");
        text.add("doce");
        text.add("ecod");
        text.add("framer");
        text.add("frame");

        Collection<String> names = new ArrayList<>(text);
        names.add("John");
        names.add("Ana");
        names.add("Mary");
        names.add("Anthony");
        names.add("Mark");

        names.stream().sorted().collect(Collectors.toList());

        funWithAnagrams(text);
    }

    public  static List<String> funWithAnagrams(List<String> text) {

        /*Optional<String> item = text.stream().reduce((a, b)->{
            if(a.length()==b.length())
                System.out.println("Same "+a);
                //text.remove(b);
            return b; // will be "a" for next reduction
        });*/

        int index = 0;
        for (String s: text) {
            if(index < text.size()) {
                String next = text.get(index + 1);


            }

        }

        //System.out.println(item.get());
        System.out.println(text);
        return new ArrayList<>();
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < steps; i++) {
            if (i < steps - 1 && path.charAt(i) == path.charAt(i + 1)) {
                count++;
            }
        }
        return 0;
    }

    public static long repeatedString(String s, long n) {

        /*int count = 0;

        String pattern = s, finalS = "";

        int length = s.length();
        long repititions =  n / length;
        long remainder =  n % length;

        System.out.printf("repititions: %s remainder: %s%n", repititions, remainder);

        for (int i = 0; i < repititions; i++) {
             finalS += pattern;
        }

        System.out.println(finalS);

        if (remainder>0) {
            finalS += (pattern.substring(0, (int) remainder));
        }

        for (int i = 0; i < finalS.length(); i++) {
            if (finalS.charAt(i) == 'a')
                count++;
        }

        System.out.println(finalS);
        System.out.println("count " + count);
        return count;*/
        long count = 0;
        for(char c : s.toCharArray())
            if(c == 'a')
                count++;

        long repititions = (n/s.length());
        long rem = (n%s.length());
        count =  repititions*count  ;
        for(int i=0;i<rem;i++)
            if(s.charAt(i)=='a')
                count++;

        return count;
    }

    public static int getHourGlassTotal(int[][] values) {
        int total = Integer.MIN_VALUE;

        for (int y = 0; y <= 3; y++) {
            for (int x = 0; x <= 3; x++) {
                // sum the top of hourglass
                int sum = values[y][x] + values[y][x+1] + values[y][x+2];

                // get the middle of hourglass
                sum += values[y+1][x+1];

                // sum the bottom of hourglass
                sum += values[y+2][x] + values[y+2][x+1] + values[y+2][x+2];

                // don't store result to keep space complexity down
                if (total < sum)
                    total = sum;
            }
        }

        return total;
    }
}
