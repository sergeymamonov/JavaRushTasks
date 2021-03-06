package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        Map<Integer, Integer> map = new HashMap<>();
        Integer data;

        while (fileInputStream.available() > 0) {
            data = fileInputStream.read();
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            }
            else {
                map.put(data, 1);
            }
        }

        fileInputStream.close();
        bufferedReader.close();

        Integer minimal = Collections.min(map.values());

        for (Integer i : map.keySet()) {
            if (map.get(i) == minimal) {
                System.out.print(i + " ");
            }
        }
    }
}
