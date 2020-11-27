package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Double> map = new TreeMap<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] params = line.split(" ");
                if (map.keySet().contains(params[0])) {
                    map.put(params[0], map.get(params[0]) + Double.parseDouble(params[1]));
                } else {
                    map.put(params[0], Double.parseDouble(params[1]));
                }
            }

            bufferedReader.close();

        }
        catch (IOException e) {
        }

        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
    }
}
