package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
try {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
    Map<Character, Integer> map = new HashMap<>();
    int c;
    while ((c = bufferedReader.read()) != -1) {
        if (map.containsKey((char)c)) {
            map.put((char)c, map.get((char)c) + 1);
        }
        else {
            map.put((char)c, 1);
        }
    }
    Map<Character, Integer> sortedMap = sortByComparator(map);

    for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
        System.out.println( entry.getKey() + " " + entry.getValue());
    }

    bufferedReader.close();
}
catch (IOException e) {
}
    }

    public static Map<Character, Integer> sortByComparator(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
