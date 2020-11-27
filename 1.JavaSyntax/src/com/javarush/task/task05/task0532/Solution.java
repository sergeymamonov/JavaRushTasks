package com.javarush.task.task05.task0532;

/* 
Задача по алгоритмам Ӏ Java Syntax: 5 уровень, 12 лекция
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int maximum;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        if (N == 1) {
            maximum = Integer.parseInt(reader.readLine());
            System.out.println(maximum);
        }
        else if (N > 1) {
            maximum = Integer.parseInt(reader.readLine());
            N--;
            while (N > 0) {
                int digit = Integer.parseInt(reader.readLine());
                if (digit > maximum) {
                    maximum = digit;
                }
                N--;
            }
            System.out.println(maximum);

        }
    }
}
