package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] array = new int[15];
        int even = 0;
        int odd = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 15; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        for (int i = 0; i < 15; i = i + 2) {
            even += array[i];
        }
        for (int i = 1; i < 15; i = i + 2) {
            odd += array[i];
        }
        if (even > odd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
        else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
