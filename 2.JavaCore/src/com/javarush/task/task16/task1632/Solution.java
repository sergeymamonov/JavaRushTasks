package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Class1 class1 = new Class1();
        Class2 class2 = new Class2();
        Class3 class3 = new Class3();
//        Class4 class4 = new Class4();
        Class5 class5 = new Class5();

        Thread thread1 = new Thread(class1);
        Thread thread2 = new Thread(class2);
        Thread thread3 = new Thread(class3);
//        Thread thread4 = new Thread(class4);
        Thread thread5 = new Thread(class5);

        Collections.addAll(threads, thread1, thread2, thread3, new T4(), thread5);
    }

    public static void main(String[] args) {
    }

    public static class T4 extends Thread implements Message {
        boolean repeat = true;

        @Override
        public void showWarning() {
            repeat = false;
        }

        @Override
        public void run() {
            while (repeat);
        }
    }
}