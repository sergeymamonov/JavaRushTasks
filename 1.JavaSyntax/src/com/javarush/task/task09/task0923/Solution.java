package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine().replaceAll("( )+", "");
        ArrayList<Character> resultVowels = new ArrayList<Character>();
        ArrayList<Character> resultConsonants = new ArrayList<Character>();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (isVowel(symbol)) {
                resultVowels.add(symbol);
            } else {
                resultConsonants.add(symbol);
            }
        }

        print(resultVowels);
        print(resultConsonants);
    }

    public static void print(ArrayList<Character> letters) {
        for (char l : letters) {
            System.out.print(l);
            System.out.print(" ");
        }
        System.out.println("");
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}