package com.javarush.task.task05.task0529;

/* 
Консоль-копилка
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int sum = 0;

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = buffer.readLine();
            if (s.equals("сумма")) {
                break;
            } else {
                int number = Integer.parseInt(s);
                sum += number;
            }
        }
        System.out.println(sum);
    }
}
