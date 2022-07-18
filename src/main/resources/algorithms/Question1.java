package com.example.studentsscores.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Question1 {
    public static void main(String[] args) {
        System.out.println(timeInWords(5, 30));
        System.out.println(timeInWords(6, 00));
        System.out.println(timeInWords(12, 45));
        System.out.println(timeInWords(00, 45));
        System.out.println(timeInWords(00, 00));
        System.out.println(timeInWords(11, 00));
        System.out.println(timeInWords(9, 15));
        System.out.println(timeInWords(3, 25));
        System.out.println(timeInWords(4, 07));
        System.out.println(timeInWords(8, 54));
        System.out.println(timeInWords(1, 23));
        System.out.println(timeInWords(14, 23));
        System.out.println(timeInWords(15, 43));

    }
    static String timeInWords(int h, int m) {
        String time;
        Map<Integer, String> timeStrings = new HashMap<>();
        timeStrings.put(0, "twelve");
        timeStrings.put(00, "twelve");
        timeStrings.put(1, "one");
        timeStrings.put(2, "two");
        timeStrings.put(3, "three");
        timeStrings.put(4, "four");
        timeStrings.put(5, "five");
        timeStrings.put(6, "six");
        timeStrings.put(7, "seven");
        timeStrings.put(8, "eight");
        timeStrings.put(9, "nine");
        timeStrings.put(10, "ten");
        timeStrings.put(11, "eleven");
        timeStrings.put(12, "twelve");
        timeStrings.put(13, "thirteen");
        timeStrings.put(14, "fourteen");
        timeStrings.put(15, "quarter");
        timeStrings.put(16, "sixteen");
        timeStrings.put(17, "seventeen");
        timeStrings.put(18, "eighteen");
        timeStrings.put(19, "nineteen");
        timeStrings.put(20, "twenty");
        timeStrings.put(21, "twenty-one");
        timeStrings.put(22, "twenty-two");
        timeStrings.put(23, "twenty-three");
        timeStrings.put(24, "twenty-four");
        timeStrings.put(25, "twenty-five");
        timeStrings.put(26, "twenty-six");
        timeStrings.put(27, "twenty-seven");
        timeStrings.put(28, "twenty-eight");
        timeStrings.put(29, "twenty-nine");
        timeStrings.put(30, "half");

        if(h >= 12){
            h = h - 12 ;
        }

        if (m == 15) {
            time = timeStrings.get(m) + " past " + timeStrings.get(h);
        } else if (m == 45) {
            time = timeStrings.get(60 - m) + " to " + timeStrings.get(h+1);
        } else if (m == 00) {
            time = timeStrings.get(h) + " o'clock";
        } else if (m > 30) {
            time = timeStrings.get(60 - m) + " minutes to " + timeStrings.get(h+1);
        } else if (m < 30) {
            time = timeStrings.get(m) + " minutes past " + timeStrings.get(h);
        } else{
            time = timeStrings.get(m) + " past " + timeStrings.get(h);
        }
        return time.substring(0,1).toUpperCase()+time.substring(1);
    }

}
