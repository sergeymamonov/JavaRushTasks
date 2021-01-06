package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
//        Integer[] array = {13, 8, 15, 5};
//        sort(array);
//        for (int i : array) {
//            System.out.print(i + " ");
//        }
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);

        final double median;

        if (array.length % 2 == 1) {
            median = array[array.length / 2];
        } else {
            median = (array[array.length / 2 - 1] + array[array.length / 2]) / 2d;
        }

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer int1, Integer int2) {
                if (int1 == int2) {
                    return 0;
                } else if (Math.abs(int1 - median) - Math.abs(int2 - median) > 0) {
                    return 1;
                } else if (Math.abs(int1 - median) - Math.abs(int2 - median) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        return array;
    }
}
