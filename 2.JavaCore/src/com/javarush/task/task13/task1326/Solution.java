package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int number;
        String line;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String filename = bufferedReader.readLine();
//            InputStream inputStream = new FileInputStream(filename);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));

            while ((line = buffer.readLine()) != null) {
                number = Integer.parseInt(line);
                if (number % 2 == 0) {
                    arrayList.add(number);
//                    addNumber(arrayList, number);
                }
            }

            buffer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Collections.sort(arrayList);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    public static void addNumber(ArrayList<Integer> arrayList, int number) {
        for (int i = 0; i < arrayList.size() && number > arrayList.get(i); i++) {
            arrayList.add(i, number);
        }
    }
}
