package com.javarush.task.task07.task0711;

/* 
Удалить и вставить
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;

        for (int i = 0; i < 5; i++) {
            arrayList.add(bufferedReader.readLine());
        }

        for (int i = 0; i < 13; i++) {
            temp = arrayList.get(4);
            arrayList.remove(4);
            arrayList.add(0, temp);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
