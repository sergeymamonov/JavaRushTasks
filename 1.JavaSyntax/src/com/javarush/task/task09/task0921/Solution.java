package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        ArrayList<Integer> numbers = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                numbers.add(Integer.parseInt(bufferedReader.readLine()));
            }
            catch (NumberFormatException e) {
                for (int i = 0; i < numbers.size(); i++) {
                    System.out.println(numbers.get(i));
                }
                break;
            }
            catch (IOException e) {
                break;
            }
        }
    }
}
