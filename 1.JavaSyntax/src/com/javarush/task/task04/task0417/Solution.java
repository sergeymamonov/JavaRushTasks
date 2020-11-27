package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());

        if (compare(a, b) && compare(b, c)) {
            System.out.println(a + " " + b + " " + c);
        }
        else if (compare(a, b)) {
            System.out.println(a + " " + b);
        }
        else if (compare(a, c)) {
            System.out.println(a + " " + c);
        }
        else if (compare(b, c)) {
            System.out.println(b + " " + c);
        }
    }

    public static boolean compare (int a, int b) {
        return a == b;
    }
}