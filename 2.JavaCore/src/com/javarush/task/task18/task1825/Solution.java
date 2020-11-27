package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        SortedSet<String> fileNames = new TreeSet();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try {
            while (!(fileName = bufferedReader.readLine()).equals("end")) {
                fileNames.add(fileName);
            }
            bufferedReader.close();
        } catch (IOException e) {
        }

        String[] fileNamePrts = fileNames.first().split(".part");
        String commonFileName = fileNamePrts[0];

        System.out.println(commonFileName);

        File commonFile = new File(commonFileName);

        try {
            String line;
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(commonFile));

            for (String f : fileNames) {
                BufferedReader bufferedReader1 = new BufferedReader(new FileReader(f));

                    while ((line = bufferedReader1.readLine()) != null) {
                        bufferedWriter.write(line);
                    }

                    bufferedReader1.close();
            }
            bufferedWriter.close();
        } catch (IOException e) {
        }
    }
}
