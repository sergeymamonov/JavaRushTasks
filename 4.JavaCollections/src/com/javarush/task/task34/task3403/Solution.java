package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public void recurse(int n) {
        if (n <= 1) {
            return;
        }
        int i = 2;
        while (true) {
            if (n % i == 0) {
                System.out.println(i);
                break;
            } else {
                i++;
            }
        }
        recurse(n / i);
    }
}
