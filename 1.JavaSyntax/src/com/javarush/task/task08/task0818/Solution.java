package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Иванов", 500);
        map.put("Сидоров", 100);
        map.put("Григорьев", 200);
        map.put("Ефимов", 300);
        map.put("Игнатов", 400);
        map.put("Жарков", 1000);
        map.put("Козлов", 1000);
        map.put("Гуськов", 1000);
        map.put("Смольянинов", 300);
        map.put("Лавров", 200);

        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            if (pair.getValue() < 500) {
//                System.out.println(pair.getKey() + " - " + pair.getValue());
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
//        removeItemFromMap(createMap());
    }
}