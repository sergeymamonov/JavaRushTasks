package com.javarush.task.task08.task0822;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int result = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < result) {
                result = array.get(i);
            }
        }
        return result;
    }

    public static List<Integer> getIntegerList() throws IOException {
        List<Integer> integerList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int i = 0;
        while (i < N) {
            integerList.add(Integer.parseInt(bufferedReader.readLine()));
            i++;
        }
        return integerList;
    }
}
