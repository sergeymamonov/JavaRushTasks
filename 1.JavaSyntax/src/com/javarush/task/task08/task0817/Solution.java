package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Иванов", "Иван");
        map.put("Петров", "Петр");
        map.put("Сидоров", "Иван");
        map.put("Жарков", "Алексей");
        map.put("Мамонов", "Сергей");
        map.put("Андреев", "Дмитрий");
        map.put("Козловв", "Константин");
        map.put("Соболев", "Иван");
        map.put("Охлобыстин", "Иван");
        map.put("Смирнов", "Петр");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> removedNames = new ArrayList<String>();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String name = pair.getValue();
            if (names.contains(name)) {
                removedNames.add(name);
                iterator.remove();
//                System.out.println(name + " sent in function");
            } else {
//                System.out.println(name + " added in list");
                names.add(name);
            }
        }
        for (String n : removedNames) {
            removeItemFromMapByValue(map, n);
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
    }
}
