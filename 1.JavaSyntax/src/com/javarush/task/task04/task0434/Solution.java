package com.javarush.task.task04.task0434;

/* 
Таблица умножения Ӏ Java Syntax: 4 уровень, 10 лекция
*/

public class Solution {
    public static void main(String[] args) {
        int column = 1;
        while (column <= 10) {
            int row = 1;
            while (row <= 10) {
                System.out.print((row * column) + " ");
                row++;
            }
            System.out.println("");
            column++;
        }
    }
}
