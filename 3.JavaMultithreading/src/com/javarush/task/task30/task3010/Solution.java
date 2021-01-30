package com.javarush.task.task30.task3010;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
            for (int i = 2; i <= 36; i++) {
                try {
                    BigInteger bigInteger = new BigInteger(args[0], i);
                    System.out.println(i);
                    return;
                } catch (Exception e) {

                }
            }
        System.out.println("incorrect");
    }
}