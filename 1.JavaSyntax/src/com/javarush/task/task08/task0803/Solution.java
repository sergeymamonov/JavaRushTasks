package com.javarush.task.task08.task0803;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Коллекция Map из котов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] cats = new String[]{"васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс", "борис", "визя", "гарфи"};

        Map<String, Cat> map = addCatsToMap(cats);

        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


    public static Map<String, Cat> addCatsToMap(String[] cats) {
        Map<String, Cat> map = new HashMap<String, Cat>();

//        Cat cat1 = new Cat("васька");
//        Cat cat2 = new Cat("мурка");
//        Cat cat3 = new Cat("дымка");
//        Cat cat4 = new Cat("рыжик");
//        Cat cat5 = new Cat("серый");
//        Cat cat6 = new Cat("снежок");
//        Cat cat7 = new Cat("босс");
//        Cat cat8 = new Cat("борис");
//        Cat cat9 = new Cat("визя");
//        Cat cat10 = new Cat("гарфи");
//
//        map.put(cats[0], cat1);
//        map.put(cats[1], cat2);
//        map.put(cats[2], cat3);
//        map.put(cats[3], cat4);
//        map.put(cats[4], cat5);
//        map.put(cats[5], cat6);
//        map.put(cats[6], cat7);
//        map.put(cats[7], cat8);
//        map.put(cats[8], cat9);
//        map.put(cats[9], cat10);

        for (int i = 0; i < cats.length; i++) {
            map.put(cats[i], new Cat(cats[i]));
        }

        return map;
    }


    public static class Cat {
        String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name != null ? name.toUpperCase() : null;
        }
    }
}
