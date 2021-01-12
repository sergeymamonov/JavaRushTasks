package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Избавляемся от меток
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
        ArrayList<Boolean> checker = new ArrayList<>();
        int max = string.length() - substring.length();
        for (int i = 0; i <= max; i++) {
            checker.clear();
            for (int a = 0; a < substring.length(); a++) {
                checker.add(false);
            }
            int length = substring.length();
            int j = i;
            int k = 0;
            while (length-- != 0) {
                if (string.charAt(j++) == substring.charAt(k)) {
                    checker.set(k, true);
                    k++;
                }
            }
            if (!checker.contains(false)) {
                return true;
            }
        }
        return false;
    }
}

