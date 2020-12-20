package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        int firstPosition = string.indexOf('\t');
        if (firstPosition != -1) {
            firstPosition++;
        } else {
            throw new TooShortStringException();
        }
        int secondPosition = string.indexOf('\t', firstPosition);
        if (secondPosition == -1) {
            throw new TooShortStringException();
        }

        return string.substring(firstPosition, secondPosition);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
