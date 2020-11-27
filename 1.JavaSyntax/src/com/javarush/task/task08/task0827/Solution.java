package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
        System.out.println(isDateOdd("JAN 1 2013"));
        System.out.println(isDateOdd("JAN 2 2013"));
        System.out.println(isDateOdd("JAN 3 2013"));

    }

    public static boolean isDateOdd(String date) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
//        Date dateTo;
//        try {
//            dateTo = format.parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        Date dateTo = format.parse(date);
        Date dateFrom = new Date();
        dateFrom.setHours(0);
        dateFrom.setMinutes(0);
        dateFrom.setSeconds(0);
        dateFrom.setDate(1);
        dateFrom.setMonth(0);
        dateFrom.setYear(dateTo.getYear());

        long msTimeDistance = dateTo.getTime() - dateFrom.getTime();
        double msDay = 24 * 60 * 60 * 1000;
        long dayCount = (int) (Math.ceil(msTimeDistance / msDay)) + 1;
        boolean answer;
        if (dayCount % 2 == 0)
            answer = false;
        else
            answer = true;

//        System.out.println(dateTo + " - " + answer + " dayCount = " + dayCount + " " + dateFrom + " " + msTimeDistance);
        System.out.println(dateTo + " - " + answer);

        return answer;
    }
}
