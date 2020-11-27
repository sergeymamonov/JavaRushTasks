package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String filename1 = bufferedReader.readLine();
            String filename2 = bufferedReader.readLine();
            FileInputStream fileInputStream = new FileInputStream(filename1);
            FileOutputStream fileOutputStream = new FileOutputStream(filename2);
            byte[] buffer = new byte[fileInputStream.available()];
            byte[] reverse = new byte[fileInputStream.available()];
//            for (int i = buffer.length-1; i < 0; i--) {
//                fileOutputStream.write(buffer, i, 1);
//            }
            int size = buffer.length;
            fileInputStream.read(buffer);
            for (int i = 0, j = size - 1; i < size; i++, j--) {
                reverse[j] = buffer[i];
            }
            fileOutputStream.write(reverse);

            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
        }
    }
}
