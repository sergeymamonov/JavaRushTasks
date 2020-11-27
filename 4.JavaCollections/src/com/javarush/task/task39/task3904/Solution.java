package com.javarush.task.task39.task3904;

/*
Лестница
*/

public class Solution {
    private static int n = 70;
//    private static int n = 3;
//    The number of possible ascents for 5 steps is: 13
//    The number of possible ascents for 10 steps is: 274
//    The number of possible ascents for 20 steps is: 121415
//    The number of possible ascents for 40 steps is: 23837527729
//    The number of possible ascents for 60 steps is: 4680045560037375
//    The number of possible ascents for 70 steps is: 2073693258389777176

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            int i = 2;
            long sum_trib = 2;
            long prev_1 = 0;
            long prev_2 = 1;
            long prev_3 = 1;
            while (i++ < n) {
                prev_1 = prev_2;
                prev_2 = prev_3;
                prev_3 = sum_trib;
                sum_trib = prev_1 + prev_2 + prev_3;
            }
            return sum_trib;
        }
    }
}

