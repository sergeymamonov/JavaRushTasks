package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        ArrayList<FileInputStream> zipInputStreams = new ArrayList<>();
        TreeSet<String> zipPartsName = new TreeSet<>();
        String resultFileName = args[0];
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(resultFileName);
            OutputStream outputStream = new BufferedOutputStream(fileOutputStream);


            for (int i = 1; i < args.length; i++) {
                zipPartsName.add(args[i]);
            }

            for (String s : zipPartsName) {
                zipInputStreams.add(new FileInputStream(s));
            }

            ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(zipInputStreams)));

            for (ZipEntry entry = null; (entry = zipInputStream.getNextEntry()) != null; ) {

                final int bufferSize = 1024;
                byte[] buffer = new byte[bufferSize];
                for (int readBytes = -1; (readBytes = zipInputStream.read(buffer, 0, bufferSize)) > -1; ) {
                    outputStream.write(buffer, 0, readBytes);
                }
            }

            fileOutputStream.close();
            zipInputStream.close();
            outputStream.close();
        } catch (IOException e) {
        }
    }
}
