package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }

    private static String getAllNumbersBetween(int numberA, int numberB) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numberA).append(" ");
        int j = numberA < numberB ? 1 : -1;
        if (numberA != numberB) {
            do {
                numberA += j;
                stringBuilder.append(numberA).append(" ");
            } while (numberA != numberB);
        }
        return stringBuilder.toString().trim();
    }


}