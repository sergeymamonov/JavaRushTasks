package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] week = {"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String sWeekDay = bufferedReader.readLine(); //читаем строку с клавиатуры
        int weekDay = Integer.parseInt(sWeekDay);

        if (weekDay > 7 || weekDay < 1) {
            System.out.println("такого дня недели не существует");
        }
        else {
            System.out.println(week[weekDay - 1]);
        }


    }
}