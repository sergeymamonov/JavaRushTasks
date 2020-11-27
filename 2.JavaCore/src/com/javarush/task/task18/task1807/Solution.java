package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        int count = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String filename = bufferedReader.readLine();
            FileInputStream fileInputStream = new FileInputStream(filename);
            int data;

            while (fileInputStream.available() > 0) {
                data = fileInputStream.read();
                if (data == 44) {
                    count++;
                }
            }

            fileInputStream.close();
            bufferedReader.close();
        }
        catch (IOException e) {
        }

        System.out.println(count);
    }
}
