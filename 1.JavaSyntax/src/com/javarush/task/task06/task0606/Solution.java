package com.javarush.task.task06.task0606;

/* 
Чётные и нечётные циферки
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static int even = 0;
    public static int odd = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int digit = Integer.parseInt(bufferedReader.readLine());
        while (digit >= 10) {
            int lastDigit = digit % 10;
            checkSingleDigit(lastDigit);
            digit = digit / 10;
        }
        checkSingleDigit(digit);
        System.out.println("Even: " + even + " Odd: " + odd);
    }

    public static void checkSingleDigit(int digit) {
        if (digit != 0 && digit % 2 == 0) {
            even++;
        } else if (digit != 0) {
            odd++;
        }
    }
}
