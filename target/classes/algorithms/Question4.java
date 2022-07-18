package com.example.studentsscores.algorithms;

public class Question4 {
    public static void main(String[] args) {
        System.out.println(sumOfDigitsByRecursion(12345));

    }
    static int sumOfDigitsByRecursion(int n) {
        System.out.println(n%10);
        if (n == 0)
            return 0;
        return (n % 10 + sumOfDigitsByRecursion(n / 10));
    }
}
