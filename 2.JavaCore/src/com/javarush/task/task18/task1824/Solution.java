package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = null;
        String fileName = null;
        while (true) {
            try {
                fileName = bufferedReader.readLine();
                File file = new File(fileName);
                fileInputStream = new FileInputStream(file);
                fileInputStream.close();
            } catch (FileNotFoundException f) {
                System.out.println(fileName);
                break;
            } catch (IOException e) {
            }
        }
    }
}
