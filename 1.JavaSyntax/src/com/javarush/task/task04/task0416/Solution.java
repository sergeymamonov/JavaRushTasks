package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] colour = {"зелёный", "зелёный", "жёлтый", "красный"};

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double minut = Double.parseDouble(bufferedReader.readLine());

        int intMinut = (int)minut;

        if (intMinut < 5 && intMinut > 0) {
            System.out.println(colour[intMinut-1]);
        }
        else if (intMinut == 0 || intMinut % 5 == 0) {
            System.out.println("зелёный");

        }
        else {
            int minutOfCirle = intMinut % 5;
            System.out.println(colour[minutOfCirle-1]);
        }
    }
}