package com.javarush.task.task37.task3714;

import org.junit.Assert;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        StringBuilder romain = new StringBuilder(s.toUpperCase()).reverse();
        String romainString = romain.toString();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int decimal = 0;
        int lastNumber = 0;
        for (int i = 0; i < romainString.length(); i++) {
            char convertToDecimal = romainString.charAt(i);
            for (Character number : map.keySet()) {
                if (number.equals(convertToDecimal)) {
                    decimal = processDecimal(map.get(number), lastNumber, decimal);
                    lastNumber = map.get(number);
                    break;
                }
            }
        }
        return decimal;
    }

    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }
/*
    public static void testStorage() {
        Assert.assertEquals(romanToInteger("IV"), 4);
        Assert.assertEquals(romanToInteger("VI"), 6);
        Assert.assertEquals(romanToInteger("VIII"), 8);
        Assert.assertEquals(romanToInteger("IX"), 9);
        Assert.assertEquals(romanToInteger("XV"), 15);
        Assert.assertEquals(romanToInteger("XIX"), 19);
        Assert.assertEquals(romanToInteger("XL"), 40);
        Assert.assertEquals(romanToInteger("XLII"), 42);
        Assert.assertEquals(romanToInteger("LX"), 60);
        Assert.assertEquals(romanToInteger("LXXX"), 80);
        Assert.assertEquals(romanToInteger("LXXXIII"), 83);
        Assert.assertEquals(romanToInteger("XCIV"), 94);
        Assert.assertEquals(romanToInteger("XC"), 90);
        Assert.assertEquals(romanToInteger("CL"), 150);
        Assert.assertEquals(romanToInteger("CCLXXXIII"), 283);
        Assert.assertEquals(romanToInteger("DCCC"), 800);
        Assert.assertEquals(romanToInteger("MCMLXXXVIII"), 1988);
        Assert.assertEquals(romanToInteger("MMDCLXXXIII"), 2683);
        Assert.assertEquals(romanToInteger("MMDDCCLLXXVVII"), 3332);
        Assert.assertEquals(romanToInteger("MMMD"), 3500);
    }
 */

}
