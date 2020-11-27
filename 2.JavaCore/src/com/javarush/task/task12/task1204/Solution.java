package com.javarush.task.task12.task1204;

/* 
То ли птица, то ли лампа
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        Map<String, String> map = new HashMap<>();
        map.put("com.javarush.task.task12.task1204.Solution$Cat", "Кошка");
        map.put("com.javarush.task.task12.task1204.Solution$Dog", "Собака");
        map.put("com.javarush.task.task12.task1204.Solution$Bird", "Птица");
        map.put("com.javarush.task.task12.task1204.Solution$Lamp", "Лампа");
        String className = o.getClass().getName();
        for (String key : map.keySet()) {
            if (className.equals(key)) {
                System.out.println(map.get(key));
                break;
            }
        }
    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}
