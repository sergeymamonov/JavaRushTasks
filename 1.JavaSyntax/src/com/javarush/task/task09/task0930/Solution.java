package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам Ӏ Java Syntax: 9 уровень, 11 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i!=j) {
                    if (!isNumber(array[i]) && !isNumber(array[j])) {
                        if (isGreaterThan(array[j], array[i])) {
                            String temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                        }
                    }

                    if (isNumber(array[i]) && isNumber(array[j])) {
                        if (Integer.parseInt(array[i]) > Integer.parseInt(array[j])){
                            String temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                        }
                    }
                }
            }
        }
    }
    /*
    public static void sort(String[] array) {
        for (int i = 0; i < array.length-1; i++) {

            if (!isNumber(array[i])) {
                String str1 = array[i];
                for (int j = array.length-1; j <= i; j--) {
                    if (!isNumber(array[j])) {
                        String str2 = array[j];
                        if (isGreaterThan(str1, str2)) {
                            System.out.println(str1 + "-" + str2 + " - " + isGreaterThan(str1, str2));
                            String temp;
                            temp = array[j];
                            array[j] = array[i];
                            array[i] = temp;
                        }
//                        str1 = str2;
                    }
                }
            }
            else {
                int number1 = Integer.parseInt(array[i]);
                for (int j = i + 1; j < array.length; j++) {
                    if (isNumber(array[j])) {
                        int number2 = Integer.parseInt(array[j]);
                        if (number1 < number2) {
                            String temp;
                            temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                        }
//                        number1 = number2;
                    }
                }
            }
        }
    }
     */

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
