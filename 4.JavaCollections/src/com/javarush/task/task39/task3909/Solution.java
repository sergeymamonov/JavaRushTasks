package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isOneEditAway(String first, String second) {
        if (first.length() <= 1 && second.length() <= 1) {
            return true;
        }
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        int count = 0;
        if (first.length() == second.length()) {
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    count++;
                }
                if (count > 1) {
                    return false;
                }
            }
            return true;
        }

        String subFirst = first;
        String subSecond = second;
        for (int i = 0; i <= first.length(); i++) {
            for (int j = 0; j <= second.length(); j++) {
                if (subFirst.equals(subSecond)) return true;
                if (j == second.length()) {
                    subSecond = second;
                    break;
                }
                subSecond = removeCharByIndex(second, j);
            }
            if (i == first.length()) {
                break;
            }
            subFirst = removeCharByIndex(first, i);
        }
        return false;
    }

    private static String removeCharByIndex(String origin, int i){
        StringBuilder builder = new StringBuilder(origin);
        builder.deleteCharAt(i);
        return builder.toString();
    }
}

