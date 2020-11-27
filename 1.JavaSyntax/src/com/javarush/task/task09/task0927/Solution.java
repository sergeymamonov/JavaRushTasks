package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> map = new HashMap<>();
        map.put("Vas", new Cat("Vas"));
        map.put("Bor", new Cat("Bor"));
        map.put("Tor", new Cat("Tor"));
        map.put("Mur", new Cat("Mur"));
        map.put("Push", new Cat("Push"));
        map.put("Sne", new Cat("Sne"));
        map.put("Ush", new Cat("Ush"));
        map.put("Kosh", new Cat("Kosh"));
        map.put("Tim", new Cat("Tim"));
        map.put("Sen", new Cat("Sen"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> cats = new HashSet<>(map.values());
//        cats = map.values();
        return cats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
