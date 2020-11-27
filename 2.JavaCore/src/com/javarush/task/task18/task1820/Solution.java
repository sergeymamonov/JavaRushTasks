package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String filename1 = bufferedReader.readLine();
            String filename2 = bufferedReader.readLine();
            bufferedReader.close();

            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(filename1)));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename2));

            String line;
            ArrayList<Double> numbersDouble = new ArrayList<>();

            while ((line = bufferedReader1.readLine()) != null) {
                String[] numbersString = line.split(" ");
                for (String n : numbersString) {
                    numbersDouble.add(Double.parseDouble(n));
                }
            }

            bufferedReader1.close();

            int numberInt;
            for (double f : numbersDouble) {
                numberInt = (int) Math.abs(f);
                if (f > 0) {
                    if (f - numberInt >= 0.5) {
                        bufferedWriter.write(String.valueOf((int)Math.ceil(f)));
                    } else {
                        bufferedWriter.write(String.valueOf((int)Math.floor(f)));
                    }
                } else if (f < 0){
                    if (Math.abs(f) - numberInt <= 0.5) {
                        bufferedWriter.write(String.valueOf((int)Math.ceil(f)));
                    } else {
                        bufferedWriter.write(String.valueOf((int)Math.floor(f)));
                    }
                }
                else {
                    bufferedWriter.write(String.valueOf((int)f));
                }
                bufferedWriter.write(" ");
            }

            bufferedWriter.close();
        } catch (IOException e) {
        }
    }
}
