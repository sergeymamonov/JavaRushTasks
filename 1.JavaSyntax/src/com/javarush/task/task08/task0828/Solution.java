package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String month = bufferedReader.readLine();
        ArrayList<String> months = new ArrayList<>();
        Collections.addAll(months,"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        for (int i = 0; i < 12; i++) {
            if (month.equals(months.get(i))) {
                System.out.println(months.get(i) + " is the " + (i+1) + " month");
            }
        }
    }
}
