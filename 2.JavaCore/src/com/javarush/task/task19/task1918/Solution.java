package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        try {
            String fileName = bufferedReader.readLine();
            bufferedReader.close();

            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader1.readLine()) != null) {
                stringBuilder.append(line);
            }

            bufferedReader1.close();
        }
        catch (IOException e) {
        }

        String input = stringBuilder.toString();

        matchMaker(input, args[0]);
    }

    public static void matchMaker(String input, String tag) {
        Pattern pattern = Pattern.compile("<(" + tag + ")[^>]*?>.*?(<\\1[^>]*?>.*?</\\1>)*.*?</\\1>");
        Matcher matcher = pattern.matcher(input);
        String check;
        while (matcher.find()) {
            check = matcher.group();
            System.out.println(check);

            String t = matcher.group(2);
            if (t != null) System.out.println(t);
        }
    }
}
