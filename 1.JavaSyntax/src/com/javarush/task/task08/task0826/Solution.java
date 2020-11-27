package com.javarush.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Пять победителей
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array) {
        int temp;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j-1] < array[j]) {
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }

    }
//        if (array == null) {
//            return;
//        }
//        if (array.length < 2) {
//            return;
//        }
//        int[] arrayA = new int[array.length / 2];
//        System.arraycopy(array, 0, arrayA, 0, array.length / 2);
//
//        int [] arrayB = new int[array.length - array.length / 2];
//        System.arraycopy(array, 0, arrayB, 0, array.length - array.length / 2);
//
//        sort(arrayA);
//        sort(arrayB);
//
//        merge(arrayA, arrayB);
//    }
//
//    public static int[] merge(int [] arrayA, int [] arrayB) {
//        int [] arrayC
//    }
}
