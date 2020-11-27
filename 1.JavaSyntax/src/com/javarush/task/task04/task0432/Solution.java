package com.javarush.task.task04.task0432;

/* 
Хорошего много не бывает
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String phrase = bufferedReader.readLine();
        int quantity = Integer.parseInt(bufferedReader.readLine());

        while (quantity > 0) {
            System.out.println(phrase);
            quantity--;
        }

    }
}
