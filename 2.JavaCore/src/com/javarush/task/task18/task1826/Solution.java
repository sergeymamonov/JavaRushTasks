package com.javarush.task.task18.task1826;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
        String key = args[0];

        String fileName = args[1];
        String fileOutputName = args[2];

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
            int data;
            int deshifrator = 0;
            if (key.equals("-e")) {
                deshifrator = 1;
            } else if (key.equals("-d")) {
                deshifrator = -1;
            }
            while (fileInputStream.available() > 0) {
                data = fileInputStream.read();
                data = data + deshifrator;
                fileOutputStream.write(data);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
        }
    }

}
