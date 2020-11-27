package com.javarush.task.task07.task0715;

/* 
Продолжаем мыть раму
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Collections.addAll(arrayList, "мама", "мыла", "раму");

        for (int i = 0; i <= 4; i=i+2) {
            arrayList.add(i + 1, "именно");
        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
