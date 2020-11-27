package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try {
            while (!(fileName = bufferedReader.readLine()).equals("exit")) {
                ReadThread readThread = new ReadThread(fileName);
                readThread.start();
            }

            bufferedReader.close();
        }
        catch (IOException e) {
        }
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run() {
            Map<Integer, Integer> map = new TreeMap<>();
            int count = 0;
            int result = 0;

            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                int data;

                while (fileInputStream.available() > 0) {
                    data = fileInputStream.read();
                    if (map.containsKey(data)) {
                        map.put(data, map.get(data) + 1);
                    }
                    else {
                        map.put(data, 1);
                    }
                }

                fileInputStream.close();
            }
            catch (IOException e) {
            }

            for (int i : map.keySet()) {
                if (map.get(i) > count) {
                    count = map.get(i);
                    result = i;
                }
            }

            Solution.resultMap.put(fileName, result);
        }
    }
}
