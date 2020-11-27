package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> all = new ArrayList<>();
        ArrayList<Integer> devided3 = new ArrayList<>();
        ArrayList<Integer> devided2 = new ArrayList<>();
        ArrayList<Integer> devided = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            all.add(Integer.parseInt(bufferedReader.readLine()));
        }

        for (int i = 0; i < 20; i++) {
            if (all.get(i) % 6 == 0) {
                devided3.add(all.get(i));
                devided2.add(all.get(i));
            } else if (all.get(i) % 3 == 0) {
                devided3.add(all.get(i));
            } else if (all.get(i) % 2 == 0) {
                devided2.add(all.get(i));
            } else {
                devided.add(all.get(i));
            }
        }
            printList(devided3);
            printList(devided2);
            printList(devided);

    }

    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
