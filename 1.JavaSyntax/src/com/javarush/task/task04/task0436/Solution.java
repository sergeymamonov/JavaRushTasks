package com.javarush.task.task04.task0436;

/* 
Рисуем прямоугольник
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int row = Integer.parseInt(bufferedReader.readLine());
        int column = Integer.parseInt(bufferedReader.readLine());

        for (int j = 0; j < row; j++) {
            for (int i = 0; i < column; i++) {
                System.out.print("8");
            }
            System.out.println("");
        }
    }
}
