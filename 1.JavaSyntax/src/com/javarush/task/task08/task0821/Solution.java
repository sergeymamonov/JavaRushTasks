package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> peoples = new HashMap<>();
        peoples.put("Иванов", "Иван");
        peoples.put("Иванов", "Сергей");
        peoples.put("Мамонов", "Сергей");
        peoples.put("Юарков", "Алексей");
        peoples.put("Чудин", "Алексей");
        peoples.put("Иванов", "Кирилл");
        peoples.put("Иванов", "Петр");
        peoples.put("Иванов", "Игнат");
        peoples.put("Иванов", "Игорь");
        peoples.put("Иванов", "Виталий");

        return peoples;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
