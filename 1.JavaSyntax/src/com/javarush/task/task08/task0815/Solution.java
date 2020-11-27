package com.javarush.task.task08.task0815;

import java.util.*;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Засимов", "Алексей");
        map.put("Сахно", "Алексей");
        map.put("Аксенов", "Максим");
        map.put("Фролов", "Вячеслав");
        map.put("Цаплин", "Александр");
        map.put("Чудин", "Алексей");
        map.put("Ноздрин", "Дмитрий");
        map.put("Мельников", "Евгений");
        map.put("Жарков", "Алексей");
        map.put("Мамонов", "Сергей");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int result = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String nameFromMap = pair.getValue();
            if (name.equals(nameFromMap)) {
                result++;
            }
        }
        return result;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int result = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String lastNameFromMap = pair.getKey();
            if (lastName.equals(lastNameFromMap)) {
                result++;
            }
        }
        return result;


    }

    public static void main(String[] args) {

    }
}
