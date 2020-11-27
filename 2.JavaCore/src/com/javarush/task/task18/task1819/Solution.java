package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String filename1 = bufferedReader.readLine();
            String filename2 = bufferedReader.readLine();
            bufferedReader.close();

            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(filename1)));

            String line;
            ArrayList<String> arrayList = new ArrayList<>();
            while ((line = reader1.readLine()) != null) {
                arrayList.add(line);
            }

            BufferedWriter writer1 = new BufferedWriter(new FileWriter(filename1, false));
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(filename2)));

            int i = 0;
            while ((line = reader2.readLine()) != null){
                arrayList.add(i, line);
                i++;
            }

            for (String s : arrayList) {
                writer1.write(s);
            }

            reader1.close();
            reader2.close();
            writer1.close();

        } catch (IOException e) {

        }
    }
}
