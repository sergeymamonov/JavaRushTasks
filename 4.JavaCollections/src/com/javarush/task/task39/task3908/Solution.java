package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("aA"));
    }

    public static boolean isPalindromePermutation(String s) {
        if (s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        String sToLowerCase = s.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sToLowerCase.length(); i++) {
            if (map.containsKey(sToLowerCase.charAt(i))) {
                map.put(sToLowerCase.charAt(i), map.get(sToLowerCase.charAt(i)) + 1);
            } else {
                map.put(sToLowerCase.charAt(i), 1);
            }
        }

        if (sToLowerCase.length() % 2 == 0) {
            for (Character c : map.keySet()) {
                if ((map.get(c) + 2) % 2 == 1) {
                    return false;
                }
            }
        } else {
            int count = 0;
            for (Character c : map.keySet()) {
                if ((map.get(c) + 2) % 2 == 1) {
                    count++;
                }
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
