package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        String[] params = result.split(" ");
        int number1 = Integer.parseInt(params[0]);
        int number2 = Integer.parseInt(params[2]);
        int answer;
        if (params[1].equals("+")) {
            answer = number1 + number2;
            System.out.println(number1 + " + " + number2 + " = " + answer);
        }
        else if (params[1].equals("*")) {
            answer = number1 * number2;
            System.out.println(number1 + " * " + number2 + " = " + answer);

        }
        else {
            answer = number1 - number2;
            System.out.println(number1 + " - " + number2 + " = " + answer);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

