package com.javarush.task.task07.task0709;

/* 
Выражаемся покороче
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        int minLength;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            arrayList.add(bufferedReader.readLine());
        }

        minLength = arrayList.get(0).length();
        for (int i = 1; i < 5; i++) {
            if (arrayList.get(i).length() < minLength) {
                minLength = arrayList.get(i).length();
            }
        }

        for (int i = 0; i < 5; i++) {
            if (arrayList.get(i).length() == minLength) {
                System.out.println(arrayList.get(i));
            }
        }
    }
}
