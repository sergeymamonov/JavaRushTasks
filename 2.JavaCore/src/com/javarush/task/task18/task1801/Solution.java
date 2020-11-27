package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        int maximum = 0;
        int data;

        while (fileInputStream.available() > 0) {
            data = fileInputStream.read();
            if (data > maximum) {
                maximum = data;
            }
        }

        System.out.println(maximum);

        fileInputStream.close();
        bufferedReader.close();
    }
}
