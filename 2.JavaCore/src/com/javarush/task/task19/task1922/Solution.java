package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = bufferedReader.readLine();
            bufferedReader.close();

            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName));
            String line;

            while (bufferedReader1.ready()) {
                int counter = 0;
                line = bufferedReader1.readLine();
                String[] splitLine = line.split(" ");
                for (String s : splitLine) {
                    if (words.contains(s)) {
                        counter++;
                    }
                }
                if (counter == 2) {
                    System.out.println(line);
                }
            }
            bufferedReader1.close();
        } catch (IOException e) {
        }
    }
}
