package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> file1Lines = new ArrayList<>();
        ArrayList<String> file2Lines = new ArrayList<>();

        try {
            String file1 = bufferedReader.readLine();
            String file2 = bufferedReader.readLine();
            bufferedReader.close();

            BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
            BufferedReader fileReader2 = new BufferedReader(new FileReader(file2));
            String line;

            while (fileReader1.ready()) {
                line = fileReader1.readLine();
                file1Lines.add(line);
            }

            while (fileReader2.ready()) {
                line = fileReader2.readLine();
                file2Lines.add(line);
            }
            fileReader1.close();
            fileReader2.close();
        } catch (IOException m) {
        }
        int count1 = 0;
        int count2 = 0;


        while (count1 < file1Lines.size() && count2 < file2Lines.size()) {
            if (file1Lines.get(count1).equals(file2Lines.get(count2))) {
                lines.add(new LineItem(Type.SAME, file1Lines.get(count1)));
                count1++;
                count2++;
            } else if (count1 + 1 < file1Lines.size() && file1Lines.get(count1 + 1).equals(file2Lines.get(count2)))
                lines.add(new LineItem(Type.REMOVED, file1Lines.get(count1++)));
            else if (count2 + 1 < file2Lines.size() && file1Lines.get(count1).equals(file2Lines.get(count2 + 1)))
                lines.add(new LineItem(Type.ADDED, file2Lines.get(count2++)));
        }
        if (count1 == file1Lines.size() && count2 < file2Lines.size())
            lines.add(new LineItem(Type.ADDED, file2Lines.get(count2)));
        if (count2 == file2Lines.size() && count1 < file1Lines.size())
            lines.add(new LineItem(Type.ADDED, file1Lines.get(count1)));
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
