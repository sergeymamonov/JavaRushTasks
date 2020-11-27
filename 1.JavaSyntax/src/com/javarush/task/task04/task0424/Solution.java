package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int digitals[] = new int[3];

        for (int i = 0; i < 3; i++) {
            digitals[i] = Integer.parseInt(bufferedReader.readLine());
        }
        if (digitals[0] == digitals[1]) {
            System.out.println(3);
        }
        else if (digitals[0] == digitals[2]) {
            System.out.println(2);
        }
        else if (digitals[1] == digitals[2]) {
            System.out.println(1);
        }
    }
}
