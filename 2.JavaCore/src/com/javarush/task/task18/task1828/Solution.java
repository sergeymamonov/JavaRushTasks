package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) {
        try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String fileName = reader.readLine();
                reader.close();

                BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                ArrayList<String> fileData = new ArrayList<String>();
                String line;
                while ((line = reader1.readLine()) != null) {
                    if (!line.isEmpty()) {
                        fileData.add(line);
                    }
                }
                reader1.close();

            if (args.length != 0) {

                if ("-u".equals(args[0])) {
                    for (String s : fileData) {
                        if (s.substring(0, 8).trim().equals(args[1])) {
                            fileData.set(fileData.indexOf(s),
                                    String.format("%-8d%-30s%-8.2f%-4d",
                                            Integer.parseInt(args[1]), args[2], Float.parseFloat(args[3]), Integer.parseInt(args[4])));
                        }
                    }
                }

                if ("-d".equals(args[0]) && args.length == 2) {
                    for (String s : fileData) {
                        if (s.substring(0, 8).trim().equals(args[1])) {
                            fileData.remove(s);
                        }
                    }
                }

                BufferedWriter writer1 = new BufferedWriter(new FileWriter(fileName, false));
                writer1.write(String.valueOf(""));
                writer1.close();

                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

                for (int i = 0; i < fileData.size(); i++) {
                    writer.write(fileData.get(i));
                    if (i<fileData.size()-1) writer.write("\n");
                }

                writer.close();
            }
        }
        catch (IOException e) {
        }
    }
}
