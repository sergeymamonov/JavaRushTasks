package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        return telNumber != null
                && telNumber.matches("^(\\+(?=(\\D?\\d){12}$)|(?=(\\D?\\d){10}$))\\d*(\\(\\d{3}\\))?(\\d+-){0,2}\\d+$");
    }

    public static void main(String[] args) {

    }
}
