package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/
public class Solution {
    private static int directoriesCount = 0;
    private static int filesCount = 0;
    private static long byteCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String directoryPath = reader.readLine();
        reader.close();

        Path directory = Paths.get(directoryPath);

        if (!Files.isDirectory(directory)) {
            System.out.println(directory + " - не папка");
        } else {
            Files.walkFileTree(directory, new MyFileVisitor());

            System.out.println("Всего папок - " + (directoriesCount - 1));
            System.out.println("Всего файлов - " + filesCount);
            System.out.println("Общий размер - " + byteCount);
        }
    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            directoriesCount++;
            return super.preVisitDirectory(dir, attrs);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            filesCount++;
            byteCount += attrs.size();
            return super.visitFile(file, attrs);
        }
    }
}
