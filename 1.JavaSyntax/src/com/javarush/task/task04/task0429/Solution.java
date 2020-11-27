package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int posityve = 0;
        int negative = 0;

        for (int i = 0; i < 3; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number > 0) {
                posityve++;
            }
            else if (number < 0) {
                negative++;
            }
        }
        System.out.println("количество отрицательных чисел: " + negative);
        System.out.println("количество положительных чисел: " + posityve);
    }
}
