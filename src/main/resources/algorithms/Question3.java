package com.example.studentsscores.algorithms;

import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        var x = removeDuplicates(new int[][]{
                new int[]{1, 3, 1, 2, 3, 4, 4, 3, 5},
                new int[]{1, 1, 1, 1, 1, 1, 1}
        });
        for (var each: x) {
            System.out.println(Arrays.toString(each));
        }

    }
    static int [][] removeDuplicates(int[][] multiDimensionalArray){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < multiDimensionalArray.length; i++) {
            var each = multiDimensionalArray[i];
            for (int j = 0; j < each.length; j++) {
                if (list.contains(each[j])) {
                    each[j] = 0;
                }else{
                    list.add(each[j]);
                }
            }
            list.clear();
        }
        return multiDimensionalArray;
    }

}
