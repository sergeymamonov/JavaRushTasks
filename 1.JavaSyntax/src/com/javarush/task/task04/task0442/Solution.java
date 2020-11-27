package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        while (true) {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number == -1) {
                System.out.println(result - 1);
                break;
            }
            else {
                result += number;
            }
        }
    }
}
