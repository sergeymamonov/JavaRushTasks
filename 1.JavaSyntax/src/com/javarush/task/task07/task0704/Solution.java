package com.javarush.task.task07.task0704;

/* 
Переверни массив
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = new int[10];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(array[9-i]);
        }
    }
}

