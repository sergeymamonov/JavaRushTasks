package com.javarush.task.task08.task0801;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
Set из растений
*/

public class Solution {
    public static void main(String[] args) {
        Set<String> fructs = new HashSet<String>();
        Collections.addAll(fructs, "арбуз", "банан", "вишня", "груша", "дыня", "ежевика", "женьшень", "земляника", "ирис", "картофель");

        for (String fruct : fructs) {
            System.out.println(fruct);
        }
    }
}
