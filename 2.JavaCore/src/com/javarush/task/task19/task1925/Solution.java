package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();
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
                    if (s.length() > 6)  {
                        result.add(s);
                    }
                }
            }

            reader.close();

            writer.write(String.join(",", result));

            writer.close();
        }
        catch (IOException e) {
        }
    }
}
