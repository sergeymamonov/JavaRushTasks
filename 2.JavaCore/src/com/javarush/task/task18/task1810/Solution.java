package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String filename = bufferedReader.readLine();
            FileInputStream fileInputStream = new FileInputStream(filename);

            while (fileInputStream.available() >= 1000) {
                filename = bufferedReader.readLine();
                fileInputStream = new FileInputStream(filename);
            }

            fileInputStream.close();
            bufferedReader.close();

            throw new DownloadException();
        }
        catch (IOException e) {
        }
    }

    public static class DownloadException extends Exception {

    }
}
