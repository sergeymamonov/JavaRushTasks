package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPowerOfThree(int n) {
        if ((Math.log(n) / Math.log(3)) % 1 == 0) {
            return true;
        }
        return false;
    }
}
