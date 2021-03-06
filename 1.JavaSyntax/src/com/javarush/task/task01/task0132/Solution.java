package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int hundreds = number/100;
        int dozens = (number - hundreds*100) / 10;
        int units = number - hundreds*100 - dozens*10;
        return hundreds + dozens + units;
    }
}