package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String filename = bufferedReader.readLine();
            bufferedReader.close();
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(filename));
            String line;
            String[] columns;
            while ((line = bufferedReader1.readLine()) != null) {
                columns = line.split(" ");
                if (columns[0].equals(args[0])) {
                    System.out.println(line);
                }
            }
            bufferedReader1.close();
        } catch (IOException e) {

        }

    }
}
