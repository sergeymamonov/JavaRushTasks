package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Date date;
        SimpleDateFormat format = new SimpleDateFormat("y-MM-d");
        date = format.parse(new BufferedReader(new InputStreamReader(System.in)).readLine());
//        Date date = new SimpleDateFormat("y-MM-d").parse(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println((new SimpleDateFormat("MMM d, y", Locale.US).format(date)).toUpperCase());
    }
}
