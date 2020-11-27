package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        Queue<File> files = new PriorityQueue<>();

        File originalDirectory = new File(root);
        Collections.addAll(files, originalDirectory.listFiles());

        while (!files.isEmpty()) {
            File currentFile = files.remove();
            if (currentFile.isDirectory()) {
                Collections.addAll(files, currentFile.listFiles());
            }
            else {
                result.add(currentFile.getAbsolutePath());
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
