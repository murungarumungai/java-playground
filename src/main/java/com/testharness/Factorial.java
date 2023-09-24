package com.testharness;

public class Factorial {

    public static void main(String[] args) {

        Factorial f = new Factorial();
        var rec = f.getFactorial(30);
        System.out.println(rec);
    }

    private int getFactorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        if (n<0) {
            return -1;
        }

        return n * getFactorial(n-1);

    }
}
