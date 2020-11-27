package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileReader fileReader = new FileReader(reader.readLine());
            StringBuilder builder = new StringBuilder();

            while (fileReader.ready()) {
                builder.append((char) fileReader.read());
            }

            String s = builder.toString();
            String str = s.replaceAll("[^A-Za-z]", ",");


            String[] sp = str.split(",");
            int a = 0;
            for (int i = 0; i < sp.length; i++) {
                sp[i].toString();
                if (sp[i].equals("world"))
                    a++;
            }
            System.out.println(a);

            reader.close();
            fileReader.close();
        }
        catch (IOException e) {

        }
    }
}
