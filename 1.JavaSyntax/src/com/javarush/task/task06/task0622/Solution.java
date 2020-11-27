package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> digits = new ArrayList<Integer>();

        read(digits);
        sort(digits);
        print(digits);
    }


    public static void read(ArrayList<Integer> digits) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            int digit = Integer.parseInt(reader.readLine());
            digits.add(digit);
        }
    }

    public static void print(ArrayList<Integer> digits) {
        for (int i = 0; i < 5; i++) {
            System.out.println(digits.get(i));
        }
    }

    public static void sort(ArrayList<Integer> digits) {
        for (int i = 4; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (digits.get(j) > digits.get(j+1)) {
                    int temp = digits.get(j);
                    digits.set(j, digits.get(j+1));
                    digits.set(j+1, temp);

                }
            }
        }
    }

//    public static void swap(int first, int second) {
//        int temp = digits.get(first);
//        first = digit.set();
//        second = temp;
//    }
}