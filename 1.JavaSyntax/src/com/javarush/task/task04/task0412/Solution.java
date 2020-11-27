package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String snumber = bufferedReader.readLine(); //читаем строку с клавиатуры
        int number = Integer.parseInt(snumber);

        if (number > 0) {
            System.out.println(number * 2);
        }
        else if (number < 0) {
            System.out.println(number + 1);
        }
        else {
            System.out.println("0");
        }


    }

}