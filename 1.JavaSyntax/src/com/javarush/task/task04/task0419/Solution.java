package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double[] numbers = new double[4];
        double NEGATIVE_INFINITY = -1.0 / 0.0;
        double result = NEGATIVE_INFINITY;
        for (int i = 0; i < 4; i++) {
            numbers[i] = Double.parseDouble(bufferedReader.readLine());
            if(numbers[i] > result) {
                result = numbers[i];
            }
        }
        System.out.println(result);
    }
}
