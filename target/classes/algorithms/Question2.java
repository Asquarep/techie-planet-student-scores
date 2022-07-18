package com.example.studentsscores.algorithms;

public class Question2 {
    public static void main(String[] args) {
        staircase(3);
    }
    static void staircase(int N){
        String s = "#";
        int steps = 1;
        while (steps<=N){
            System.out.println(s.repeat(steps));
            steps++;
        }
    }
}
