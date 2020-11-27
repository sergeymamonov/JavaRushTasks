package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        String fileName1 = args[0];
        String fileName2 = args[1];

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName1));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));

            String line;

            while (reader.ready()) {
                line = reader.readLine();
                String[] words = line.split(" ");
                for (String s : words) {
                    if (s.matches(".*[0-9]+.*")) {
                        writer.write(s + " ");
                    }
                }
            }

            reader.close();
            writer.close();
        }
        catch (IOException e) {
        }
    }
}
