package com.javarush.task.task08.task0813;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, "Лава", "Лапа", "Лама", "Лавка", "Ласка",
                "Лампа", "Ля", "Лара", "Лук", "Лев",
                "Лот", "Лето", "Лес", "Лось", "Люк",
                "Ликбез", "Леопард", "Леденец", "Лед", "Люпин");
        return set;
    }

    public static void main(String[] args) {

    }
}
