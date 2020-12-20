package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        File fileSource = new File(args[0]);
        File fileDestination = new File(args[1]);

        FileInputStream inputStream= new FileInputStream(fileSource);
        FileOutputStream outStream = new FileOutputStream(fileDestination);

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        inputStream.close();

        String string = new String (buffer, windows1251);

        outStream.write(string.getBytes(utf8));
        outStream.close();
    }
}
