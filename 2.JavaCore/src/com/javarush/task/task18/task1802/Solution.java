package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        Integer minimum = Integer.MAX_VALUE;
        int data;

        while (fileInputStream.available() > 0) {
            data = fileInputStream.read();
            if (data < minimum) {
                minimum = data;
            }
        }

        System.out.println(minimum);

        fileInputStream.close();
        bufferedReader.close();
    }
}
