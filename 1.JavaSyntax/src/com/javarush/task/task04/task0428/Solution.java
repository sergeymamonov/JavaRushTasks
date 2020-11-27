package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        for (int i = 0; i < 3; i++) {
            int number= Integer.parseInt(bufferedReader.readLine());
            if (number > 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}
