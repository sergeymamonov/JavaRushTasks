package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int maxLength;
        int minLength;

        for (int i = 0; i < 10; i++) {
            arrayList.add(bufferedReader.readLine());
        }

        maxLength = arrayList.get(0).length();
        minLength = arrayList.get(0).length();
        for (int i = 1; i < 10; i++) {
            if (arrayList.get(i).length() > maxLength) { maxLength = arrayList.get(i).length(); }
            if (arrayList.get(i).length() < minLength) { minLength = arrayList.get(i).length(); }
        }

        for (int i = 0; i < 10; i++) {
            if (arrayList.get(i).length() == maxLength || arrayList.get(i).length() == minLength) {
                System.out.println(arrayList.get(i));
                break;
            }
        }
    }
}
