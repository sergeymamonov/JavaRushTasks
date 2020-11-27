package com.javarush.task.task19.task1926;

import java.io.*;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = bufferedReader.readLine();
            bufferedReader.close();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            while (reader.ready()) {
                String line = reader.readLine();
                StringBuilder stringBuilder = new StringBuilder(line);
                System.out.println(stringBuilder.reverse().toString());
            }

            reader.close();
        } catch (IOException e) {

        }
    }
}
