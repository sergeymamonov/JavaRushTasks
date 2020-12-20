package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.WeekFields;
import java.util.Locale;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        try {
            if (date.contains(":") && date.contains(".")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy H:m:s");
                LocalDate localDate = LocalDate.parse(date, formatter);
                LocalTime localTime = LocalTime.parse(date, formatter);

                printDate(localDate);
                printTime(localTime);
            } else if (date.contains(":")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m:s");
                LocalTime localTime = LocalTime.parse(date, formatter);
                printTime(localTime);
            } else if (date.contains(".")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");
                LocalDate localDate = LocalDate.parse(date, formatter);
                printDate(localDate);
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
    }

    private static void printTime(LocalTime localTime) {
        if (localTime.getHour() > 12) {
            System.out.println("AM или PM: PM");
            System.out.println("Часы: " + (localTime.getHour() - 12));
        } else {
            System.out.println("AM или PM: AM");
            System.out.println("Часы: " + localTime.getHour());
        }

        System.out.println("Часы дня: " + localTime.getHour());
        System.out.println("Минуты: " + localTime.getMinute());
        System.out.println("Секунды: " + localTime.getSecond());
    }

    private static void printDate(LocalDate localDate) {
        System.out.println("День: " + localDate.getDayOfMonth());
        System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
        System.out.println("День месяца: " + localDate.getDayOfMonth());
        System.out.println("День года: " + localDate.getDayOfYear());
        System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
        System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
        System.out.println("Месяц: " + localDate.getMonthValue());
        System.out.println("Год: " + localDate.getYear());
    }
}
