package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String phrase = bufferedReader.readLine();
            if (phrase.equals("exit")) {
                break;
            } else {
                try {
                    if (phrase.contains(".")) {
                        Double num = Double.parseDouble(phrase);
                        print(num);
                    } else {
                        int number = Integer.parseInt(phrase);
                        if (number > 0 && number < 128) {
                            print((short) number);
                        } else if (number <= 0 || number >= 128) {
                            print(number);
                        }
                    }
                } catch (Exception e) {
                    print(phrase);
                }

            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
