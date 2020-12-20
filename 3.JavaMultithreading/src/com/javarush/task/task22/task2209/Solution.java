package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = null;
        try {
            filename = bufferedReader.readLine();
            bufferedReader = new BufferedReader(new FileReader(new File(filename)));
            StringBuilder result = getLine(bufferedReader.readLine().split(" "));
            System.out.println(result.toString());
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        ArrayList<String> cities = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("");
        ArrayList<Integer> usedCities = new ArrayList<>();
        if (words == null || words.length == 0) {
            return stringBuilder;
        }

        for (String s : words) {
            cities.add(s);
        }

        for (int k = 0; k < cities.size(); k++) {
            stringBuilder.delete(0, stringBuilder.length());
            usedCities.clear();
            stringBuilder.append(cities.get(k) + " ");
            usedCities.add(k);
            String currentSign = cities.get(k).substring(cities.get(k).length() - 1).toUpperCase();

            for (int j = 0; j < cities.size(); j++) {
                for (int i = 0; i < cities.size(); i++) {
                    if (usedCities.contains(i)) {
                        continue;
                    }
                    if (currentSign.equals(cities.get(i).substring(0, 1).toUpperCase())) {
                        currentSign = cities.get(i).substring(cities.get(i).length() - 1).toUpperCase();
                        stringBuilder.append(cities.get(i) + " ");
                        usedCities.add(i);
                        break;
                    }
                }
            }
            if (usedCities.size() == cities.size()) {
                break;
            }
        }
        return stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
    }
}
