package com.javarush.task.task36.task3607;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.SynchronousQueue;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 10 лекция
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        return new DelayQueue<>().getClass();
    }
}