package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            int data;
            int allSign = 0;
            int space = 0;
            if (fileInputStream.available() > 0) {
                while (fileInputStream.available() > 0) {
                    data = fileInputStream.read();
                    allSign++;
                    if (data == ' ') {
                        space++;
                    }
                }
                float result = (float)space / allSign * 100;
                System.out.println(String.format("%.2f", result));

            }
            fileInputStream.close();
        }
        catch (IOException e) {

        }
    }
}
