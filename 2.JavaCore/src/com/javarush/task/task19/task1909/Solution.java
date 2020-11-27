package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
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

            String str = stringBuilder.toString().replaceAll("\\.", "\\!");

            bufferedWriter.write(str);

            bufferedReader1.close();
            bufferedWriter.close();
        }
        catch (IOException e) {

        }
    }
}
