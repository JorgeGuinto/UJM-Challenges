package com.jorgeguinto.mylibrary;

public class Series {
    public static int nSum (int n) {
        if (n < 0) {
            return -1;
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static int factorial (int n) {
        if (n < 0) {
            return -1;
        }

        int factorial = 1;
        for (int i = n; i >= 1; i--) {
            factorial = factorial*i;
        }
        return factorial;
    }

    public static int fibonacci (int n) {
        if (n < 0) {
            return -1;
        } else if (n <= 1) {
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}
