package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            numbers.add(Integer.parseInt(bufferedReader.readLine()));
        }
        int max = 1;
        int result = 1;

        for (int i = 1; i < 10; i++) {
            if (numbers.get(i).equals(numbers.get(i - 1))) {
                result++;
                if (result > max) {
                    max = result;
                }
            } else {
                result = 1;
            }
        }
        System.out.println(max);

    }
}