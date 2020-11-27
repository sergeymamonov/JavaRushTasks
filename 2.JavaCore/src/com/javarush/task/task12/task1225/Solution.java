package com.javarush.task.task12.task1225;

/* 
Посетители
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        Map<String, String> map = new HashMap<>();
        map.put("com.javarush.task.task12.task1225.Solution$Cat", "Кот");
        map.put("com.javarush.task.task12.task1225.Solution$Tiger", "Тигр");
        map.put("com.javarush.task.task12.task1225.Solution$Lion", "Лев");
        map.put("com.javarush.task.task12.task1225.Solution$Bull", "Бык");
        map.put("com.javarush.task.task12.task1225.Solution$Cow", "Корова");
        map.put("com.javarush.task.task12.task1225.Solution$Animal", "Животное");

        String type = o.getClass().getName();

        for (String t : map.keySet()) {
            if (type.equals(t)) {
                return map.get(type);
            }
        }
        return "Животное";
    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}
