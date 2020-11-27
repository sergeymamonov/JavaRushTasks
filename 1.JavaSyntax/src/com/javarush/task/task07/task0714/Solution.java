package com.javarush.task.task07.task0714;

/* 
Слова в обратном порядке
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            arrayList.add(bufferedReader.readLine());
        }

        arrayList.remove(2);

        for (int i = arrayList.size()-1; i >= 0; i--) {
            System.out.println(arrayList.get(i));
        }
    }
}
