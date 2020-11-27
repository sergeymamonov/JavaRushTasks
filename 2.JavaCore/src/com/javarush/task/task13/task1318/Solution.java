package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        /*
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));

        InputStream inputStream = new FileInputStream(fileName);
        OutputStream outputStream = new OutputStream();
        try {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                outputStream.write(data);
            }
            inputStream.close();
            outputStream.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
*/

        InputStream inputStream = null;
        BufferedInputStream buffer = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String fileName = bufferedReader.readLine();

            inputStream = new FileInputStream(fileName);

            buffer = new BufferedInputStream(inputStream);

            while (buffer.available() > 0) {

                char c = (char) buffer.read();

                System.out.print(c);
            }

            inputStream.close();
            buffer.close();
            bufferedReader.close();
        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}