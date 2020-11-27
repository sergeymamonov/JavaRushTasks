package com.javarush.task.task07.task0705;

/* 
Один большой массив и два маленьких
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] bigArray = new int[20];
        int[] smallArray1 = new int[10];
        int[] smallArray2 = new int[10];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            bigArray[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < 10; i++) {
            smallArray1[i] = bigArray[i];
        }

        for (int i = 0; i < 10; i++) {
            smallArray2[i] = bigArray[i+10];
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(smallArray2[i]);
        }
    }
}
