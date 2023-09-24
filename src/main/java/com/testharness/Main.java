package com.testharness;

import java.text.BreakIterator;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Stack stacki = new Stack();
        stacki.push(1);
        stacki.push(2);
        stacki.push(3);
        stacki.push(4);

        stacki.pop();

        System.out.println(stacki.peek());
        System.out.println(stacki.size());
        System.out.println(stacki.isEmpty());
        System.out.println(stacki.search(3));
        System.out.println(stacki.search(2));
        System.out.println(stacki.search(1));
        System.out.println(stacki);


        /*Main fibo = new Main();

        int fib = fibo.fibonnaci(1000);*/
        //System.out.println(fib);

        String str = "Forget  CVs..Save time . x x";
        //String str = "We test coders. Give us a try?";

        //str = str.replaceAll("\\s{2,}"," ");

        //String[] words = str2.split("\\W+");
        TwoDimensionalArray twoDimensionalArray = new TwoDimensionalArray(2,3);

        Stack stack = new Stack();
        stack.push(1);
        stack.peek();

        TreeMap treeMap = new TreeMap<String, Integer>();
        treeMap.put("1",1);
        treeMap.put("1",1d);


        List<String> words = new ArrayList<String>();
        BreakIterator breakIterator = BreakIterator.getSentenceInstance();
        breakIterator.setText(str);

        int lastIndex = breakIterator.first();

        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE ) {
                words.add(str.substring(firstIndex, lastIndex));
            }
        }


        // Return number of words
        // in the given string
        System.out.println("length " + words.size());
        System.out.println("words " + words);

        String[] tokens = str.split("\\?|\\.|\\!");
        System.out.println("tokens "+ Arrays.toString(tokens));

        /*Solution solution = new Solution();
        int result = solution.countWords("Forget  CVs..Save time . x x");
        System.out.println(result);*/

        String S = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
            "john.png, London, 2015-06-20 15:13:22\n" +
            "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
            "photo.jpg, Warsaw, 2013-09-05 14:08:15\n";

        String photos[] = S.split(System.lineSeparator());
        System.out.println("photo " + Arrays.toString(photos));
        System.out.println("photo length " + photos.length);

        String result = "";

        StringBuilder builder = new StringBuilder();

        int cityCounter = 1;

        String currentCity = "";

        for (String photo : photos) {

            //split s using comma
            String[] photoDetails = photo.split(",");

            currentCity = photoDetails[1];

            if (currentCity != photoDetails[1]) {
                cityCounter++;
            }

            cityCounter = getCityCounter(currentCity, Arrays.asList(photos));
            cityCounter++;

            //appending city
            builder.append(photoDetails[1]);
            builder.append(cityCounter);

            //get extension
            builder.append("." + getExtension(photoDetails[0]).get());

            builder.append(System.getProperty("line.separator"));

        }

        result = builder.toString();

        System.out.println(result);

    }

    public static int getCityCounter(String city, List<String> photos) {

        AtomicInteger counter = new AtomicInteger();


        Map<String, Long> counts =
            photos.stream().collect(Collectors.groupingBy(e -> e.split(",")[0], Collectors.counting()));

        counts.entrySet().forEach(e -> {

            if (e.getKey().equals(city)) {
                counter.getAndAdd(e.getValue().intValue());
            }

            counter.getAndIncrement();
        });

        return counter.get();

    }

    public static Optional<String> getExtension(String filename) {
        return Optional.ofNullable(filename)
            .filter(f -> f.contains("."))
            .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

    public int fibonnaci(int n) {

        if (n==0 || n==1) {
            return n;
        }

        if (n < 0) {
            return -1;
        }

        return fibonnaci(n-1) + fibonnaci(n-2);
    }

    public static class Triple<T, U, V> {

        private final T first;
        private final U second;
        private final V third;

        public Triple(T first, U second, V third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public T getFirst() { return first; }
        public U getSecond() { return second; }
        public V getThird() { return third; }
    }
}
