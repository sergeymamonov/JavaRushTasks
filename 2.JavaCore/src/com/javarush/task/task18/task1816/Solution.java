package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
//        Set<Character> set = new HashSet<>();
        int count = 0;
        try {
            FileInputStream fileReader = new FileInputStream(args[0]);
            int b;
            while (fileReader.available() > 0) {
                b = fileReader.read();
                if (b >= 'A' && b <= 'Z' || b >= 'a' && b <= 'z')
                    count++;
            }
            fileReader.close();
            System.out.println(count);
        } catch (IOException e) {
        }
    }
}
