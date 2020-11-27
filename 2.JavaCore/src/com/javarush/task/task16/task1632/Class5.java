package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Class5 extends Thread {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String word;
    int result = 0;

    public void run() {
        while (true) {
            try {
                word = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (word.equals("N")) {
                System.out.println(result);
                break;
            } else {
                result += Integer.parseInt(word);
            }
        }
    }
}
