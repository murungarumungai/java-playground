package com.testharness;

public class Fibonnaci {

    public static void main(String[] args) {

        Fibonnaci fibo = new Fibonnaci();
        int fib = fibo.fibonnaci(13);
        System.out.println(fib);
    }

    private int fibonnaci(int n) {

        if (n==0 || n==1) {
            return n;
        }

        if (n < 0) {
            return -1;
        }

        return fibonnaci(n-1) + fibonnaci(n-2);
    }
}
