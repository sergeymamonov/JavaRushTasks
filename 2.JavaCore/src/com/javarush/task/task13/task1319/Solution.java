package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String filename = bufferedReader.readLine();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));

            String line;
            while (true) {
                line = bufferedReader.readLine();
                bufferedWriter.write(line + "\n");
                if (line.equals("exit")) {
                    break;
                }
            }

            bufferedWriter.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
