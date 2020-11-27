package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double result = 0;
        int count = 0;
        while (true) {
            int digit = Integer.parseInt(bufferedReader.readLine());
            if (digit == -1) {
                System.out.println(result / count);
                break;
            }
            result += digit;
            count++;
        }
    }
}

