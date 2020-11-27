package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    static {
        result = null;
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }


    public static CanFly result;

    public static void reset() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word = bufferedReader.readLine();
        if (word.equals("helicopter")) {
            result = new Helicopter();
        }
        if (word.equals("plane")) {
            result = new Plane(Integer.parseInt(bufferedReader.readLine()));
        }
//        System.out.println(result.toString());
        bufferedReader.close();

    }
}
