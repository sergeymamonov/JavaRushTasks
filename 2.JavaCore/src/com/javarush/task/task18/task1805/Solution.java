package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Integer data;

        while (fileInputStream.available() > 0) {
            data = fileInputStream.read();
            if (!arrayList.contains(data)) {
                arrayList.add(data);
            }
        }

        fileInputStream.close();
        bufferedReader.close();

        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (Integer i : arrayList) {
            System.out.print(i + " ");
        }
    }
}
