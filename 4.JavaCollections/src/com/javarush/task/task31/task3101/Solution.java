package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

/* 
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        TreeMap<String, String> treeMap = new TreeMap();

        File fileResult = new File(args[1]);
        File renamedFile = new File(fileResult.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(fileResult, renamedFile);

        File folder = new File(args[0]);
        treeMap = findFiles(folder, treeMap);

        FileOutputStream outputStream = new FileOutputStream(renamedFile);

        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            FileInputStream inputStream = new FileInputStream(entry.getValue());

            while (inputStream.available() > 0) {
                outputStream.write(inputStream.read());
            }
            outputStream.write("\n".getBytes());

            inputStream.close();
        }
        outputStream.close();
    }


    public static TreeMap<String, String> findFiles(File folder, TreeMap<String, String> treeMap) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                findFiles(file, treeMap);
            } else {
                if (file.length() <= 50) {
                    treeMap.put(file.getName(), file.getAbsolutePath());
                }
            }
        }
        return treeMap;
    }
}
