package com.javarush.task.task07.task0703;

/* 
Общение одиноких массивов
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            strArray[i] = bufferedReader.readLine();
        }

        for (int i = 0; i < 10; i++) {
            intArray[i] = strArray[i].length();
        }


        for (int i = 0; i < 10; i++) {
            System.out.println(intArray[i]);
        }
    }
}
