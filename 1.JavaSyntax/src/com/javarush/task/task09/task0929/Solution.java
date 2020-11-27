package com.javarush.task.task09.task0929;

import java.io.*;

/* 
Обогатим код функциональностью!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String destinationFileName = null;
        String sourceFileName = null;
        InputStream fileInputStream = null;
        try {
            sourceFileName = reader.readLine();
            fileInputStream = getInputStream(sourceFileName);
        }
        catch (Exception e) {
            System.out.println("Файл не существует.");
            sourceFileName = reader.readLine();
            fileInputStream = getInputStream(sourceFileName);
        }



        try {
            destinationFileName = reader.readLine();


        }
        catch (Exception e) {
            System.out.println("Файл не существует.");

        }


        OutputStream fileOutputStream = getOutputStream(destinationFileName);
//        InputStream fileInputStream = getInputStream(sourceFileName);
        int count = 0;
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
            count++;
        }
        System.out.println("Скопировано байт " + count);

        fileInputStream.close();
        fileOutputStream.close();


/*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String destinationFileName = null;
        String sourceFileName = reader.readLine();
        InputStream fileInputStream;
        try {
            destinationFileName = reader.readLine();
            fileInputStream = getInputStream(sourceFileName);
        } catch (Exception e) {
            System.out.println("Файл не существует.");
            sourceFileName = reader.readLine();
            fileInputStream = getInputStream(sourceFileName);
        }
        OutputStream fileOutputStream = getOutputStream(destinationFileName);
        int count = 0;
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
            count++;
        }
        System.out.println("Скопировано байт " + count);

        fileInputStream.close();
        fileOutputStream.close();
        */


        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();
        String destinationFileName = reader.readLine();

        InputStream fileInputStream = getInputStream(sourceFileName);
        OutputStream fileOutputStream = getOutputStream(destinationFileName);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();

         */
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}

