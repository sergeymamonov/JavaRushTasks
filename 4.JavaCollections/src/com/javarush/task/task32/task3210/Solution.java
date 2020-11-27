package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
            randomAccessFile.seek(Integer.parseInt(args[1]));
            String text = args[2];
            byte[] readText = new byte[text.length()];
            randomAccessFile.read(readText, 0, text.length());
            String result = new String(readText);
            String addedText = result.equals(text) ? "true" : "false";
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(addedText.getBytes());
            randomAccessFile.close();
        } catch (IOException e) {
        }
    }
}
