package com.javarush.task.task12.task1224;

/* 
Неведома зверушка
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        Map<String, String> map = new HashMap<>();
        map.put("com.javarush.task.task12.task1224.Solution$Cat", "Кот");
        map.put("com.javarush.task.task12.task1224.Solution$Tiger", "Тигр");
        map.put("com.javarush.task.task12.task1224.Solution$Lion", "Лев");
        map.put("com.javarush.task.task12.task1224.Solution$Bull", "Бык");
        map.put("com.javarush.task.task12.task1224.Solution$Pig", "Животное");

        String type = o.getClass().getName();

        for (String t : map.keySet()) {
            if (type.equals(t)) {
                return map.get(type);
            }
        }
        return "Животное";
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}
