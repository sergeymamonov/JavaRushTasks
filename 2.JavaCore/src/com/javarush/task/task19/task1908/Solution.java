package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = bufferedReader.readLine();
            String fileName2 = bufferedReader.readLine();
            bufferedReader.close();

            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName1));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader1.readLine()) != null) {
                stringBuilder.append(line);
            }

            String s = stringBuilder.toString();
            String[] sp = s.split(" ");

            for (String str : sp) {
                if (str.matches("\\d*")) {
                    bufferedWriter.write(str);
                    bufferedWriter.write(" ");
                }
            }

            bufferedReader1.close();
            bufferedWriter.close();
        } catch (IOException e) {

        }
    }
}
