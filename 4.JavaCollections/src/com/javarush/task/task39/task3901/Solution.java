package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int longest = 0;
        int current = 0;
        HashSet<Character> currentSymbols = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (currentSymbols.contains(s.charAt(i))) {
                if (current > longest) {
                    longest = current;
                }
                currentSymbols.clear();
                current = 0;
            }
            currentSymbols.add(s.charAt(i));
            current++;
        }
        return longest > current ? longest : current;
    }
}
