package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        StringBuilder text = new StringBuilder(number + " =");
        String[] line = (0 + Integer.toString(number, 3)).split("");
        for (int i = line.length - 1; i >= 0; i--) {
            if (line[i].equals("2")) {
                line[i] = "-1";
                line[i - 1] = String.valueOf((Integer.parseInt(line[i - 1])) + 1);
            } else if (line[i].equals("3")) {
                line[i] = "0";
                line[i - 1] = String.valueOf((Integer.parseInt(line[i - 1])) + 1);
            }
        }
        for (int i = line.length - 1; i >= 0; i--) {

            switch (line[i]) {
                case "1":
                    text.append(" + " + (int) Math.pow(3, line.length - 1 - i));
                    break;
                case "-1":
                    text.append(" - " + (int) Math.pow(3, line.length - 1 - i));
                    break;
                case "0":
                    break;
            }
        }
        System.out.println(text.toString());
    }
}