package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
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
                String newLine = line.replaceAll("[\\p{Punct}\\n]", "");
                stringBuilder.append(newLine);
            }

            bufferedReader1.close();

            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.close();
        }
        catch (IOException e) {

        }
    }
}
