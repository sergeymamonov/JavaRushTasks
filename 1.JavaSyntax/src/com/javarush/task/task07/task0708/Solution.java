package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;


    public static void main(String[] args) throws Exception {
        strings = new ArrayList<String>(5);
        int maxLenght;
        ArrayList<String> results = new ArrayList<String>();
        ;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            strings.add(bufferedReader.readLine());
        }

        maxLenght = strings.get(0).length();
        results.add(strings.get(0));

        for (int i = 0; i < 5; i++) {
            if (strings.get(i).length() > maxLenght) {
                maxLenght = strings.get(i).length();
            }
        }

        for (int i = 0; i < 5; i++) {
            if (strings.get(i).length() == maxLenght) {
                System.out.println(strings.get(i));
            }
        }


//        for (int i = 1; i < 5; i++) {
//            if (strings.get(i).length() > maxLenght) {
//                maxLenght = strings.get(i).length();
//                results.clear();
//                results.add(strings.get(i));
//            }
//            if (strings.get(i).length() == maxLenght) {
//                results.add(strings.get(i));
//            }
//        }
//
//        for (String result:results) {
//            System.out.println(result);
//        }
        }
    }
