package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
//        int size = strings.size();
        for (int i = 0; i < strings.size(); ) {
            String word = strings.get(i);
            if (word.contains("л") && !word.contains("р")) {
                strings.add(i + 1, word);
                i += 2;
            }

            else if (word.contains("р")) {
                if (!word.contains("л")) {
                    strings.remove(word);
                }
                else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return strings;
    }
}