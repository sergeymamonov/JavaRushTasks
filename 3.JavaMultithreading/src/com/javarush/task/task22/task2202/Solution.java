package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));

//        System.out.println(getPartOfString("Моя задача не работает, как требует условие"));
//        System.out.println(getPartOfString("Тесты для слабаков"));
//        System.out.println(getPartOfString("День числа пи — неофициальный праздник, который отмечается любителями математики 14 марта в 1:59:26 в честь математической константы — числа пи."));
//        System.out.println(getPartOfString("День был отмечен в 1988 году в научно-популярном музее Эксплораториум"));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        try {
            int firstPosition = string.indexOf(" ");
            int currentPosition = firstPosition;
            for (int i = 0; i < 3; i++) {
                currentPosition = string.indexOf(" ", currentPosition + 1);
                if (currentPosition == -1) {
                    throw new TooShortStringException();
                }
            }
            if (string.substring(currentPosition + 1).contains(" ")) {
                return string.substring(firstPosition + 1, string.indexOf(" ", currentPosition + 1)).trim();
            } else {
                return string.substring(firstPosition).trim();
            }
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
