package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a =  Integer.parseInt(bufferedReader.readLine());
        int b =  Integer.parseInt(bufferedReader.readLine());
        int c =  Integer.parseInt(bufferedReader.readLine());

        if (triangleExists(a, b, c) && triangleExists(b, c, a) && triangleExists(c, a, b)) {
            System.out.println("Треугольник существует.");
        }
        else {
            System.out.println("Треугольник не существует.");
        }
    }
    public static boolean triangleExists(int a, int b, int c) {
        return a < (b + c);
    }
}