package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String filename1 = bufferedReader.readLine();
            String filename2 = bufferedReader.readLine();
            String filename3 = bufferedReader.readLine();
            bufferedReader.close();

            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(filename2)));
            BufferedReader reader3 = new BufferedReader(new InputStreamReader(new FileInputStream(filename3)));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename1, true));

            String line;
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
            }

            while ((line = reader3.readLine()) != null) {
                writer.write(line);
            }

            reader2.close();
            reader3.close();
            writer.close();

        } catch (IOException e) {

        }

    }
}
