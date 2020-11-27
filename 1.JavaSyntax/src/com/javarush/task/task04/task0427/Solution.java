package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        String answer = "";

        if (number >= 1 && number <= 999) {
            if (number % 2 == 0) {
                answer = "четное";
            }
            else {
                answer = "нечетное";
            }
            if ((number / 100) > 0) {
                answer += " трехзначное число";
            }
            else if ((number / 10) > 0) {
                answer += " двузначное число";
            }
            else {
                answer += " однозначное число";
            }
            System.out.println(answer);
        }
    }
}
