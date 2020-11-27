package com.javarush.task.task09.task0928;

import java.io.*;

/* 
Код не компилится…
*/

public class Solution {
    public static void main(String[] args) throws IOException {
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



        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        OutputStream fileOutputStream = out(reader);
//        String sourceFileName = reader.readLine();
//        fileOutputStream = getOutputStream(sourceFileName);

        InputStream fileInputStream = in(reader);
//        String destinationFileName = reader.readLine();
//        fileInputStream = getInputStream(destinationFileName);


        while (fileInputStream.read() > 0) {
                int data = fileInputStream.read();
                fileOutputStream.write(data);
                count++;
            }

        System.out.println("Скопировано байт " + count);

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
/*
    public static OutputStream out(BufferedReader reader) {
        OutputStream fileOutputStream = null;
        try {
            String destinationFileName = reader.readLine();

            fileOutputStream = getOutputStream(destinationFileName);
//            String sourceFileName = reader.readLine();
//            fileOutputStream = getOutputStream(sourceFileName);
        }
        catch (IOException e) {
            System.out.println("Файл не существует.");
//            System.out.println("File not exists");
        }
        return fileOutputStream;
    }

    public static InputStream in(BufferedReader reader) {

        InputStream fileInputStream = null;
//        while (fileInputStream == null) {
            try {
                String sourceFileName = reader.readLine();

                fileInputStream = getInputStream(sourceFileName);
//                String destinationFileName = reader.readLine();
//                fileInputStream = getInputStream(destinationFileName);
            } catch (IOException e) {
                System.out.println("Файл не существует.");

//                System.out.println("File not exists");

//                String sourceFileName = reader;
//            }
        }
        return fileInputStream;
    }

 */
}
