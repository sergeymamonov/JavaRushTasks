package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = bufferedReader.readLine();
            String fileName2 = bufferedReader.readLine();
            bufferedReader.close();

            FileReader fileReader = new FileReader(fileName1);
            FileWriter fileWriter = new FileWriter(fileName2);

            while (fileReader.ready()) {
                fileReader.read();
                fileWriter.write(fileReader.read());
            }

            fileReader.close();
            fileWriter.close();
        }
        catch (IOException e) {

        }
    }
}
