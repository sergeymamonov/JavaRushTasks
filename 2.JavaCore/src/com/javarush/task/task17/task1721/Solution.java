package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String filename1 = bufferedReader.readLine();
            String filename2 = bufferedReader.readLine();
            File file1 = new File(filename1);
            File file2 = new File(filename2);

            FileReader fileReader1 = new FileReader(file1);
            FileReader fileReader2 = new FileReader(file2);

            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

            String line1 = bufferedReader1.readLine();
            String line2 = bufferedReader2.readLine();

            while (!(line1 == null)) {
                allLines.add(line1);
                line1 = bufferedReader1.readLine();
            }

            while (!(line2 == null)) {
                forRemoveLines.add(line2);
                line2 = bufferedReader2.readLine();
            }

            bufferedReader.close();
            bufferedReader1.close();
            bufferedReader2.close();
            fileReader1.close();
            fileReader2.close();
        } catch (IOException e) {
        }
        try {
            Solution solution = new Solution();
            solution.joinData();
        } catch (CorruptedDataException e) {
        }
    }

    public void joinData() throws CorruptedDataException {
        boolean[] checkList = new boolean[forRemoveLines.size()];
            for (boolean b : checkList) {
                b = false;
            }

        for (String s : allLines) {
            if (forRemoveLines.contains(s)) {
                checkList[forRemoveLines.indexOf(s)] = true;
            }
        }

        for (boolean b : checkList) {
            if (b == false) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }

        for (String s : forRemoveLines) {
            allLines.remove(s);
        }
    }
}
