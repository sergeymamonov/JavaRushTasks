package com.javarush.task.task08.task0814;

import java.util.*;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        Collections.addAll(hashSet, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        return hashSet;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {

        set.removeIf(value -> value > 10);


//        Iterator<HashSet<Integer>> iterator = set.iterator();
//if (set.has)

        return set;
    }

    public static void main(String[] args) {

    }
}
