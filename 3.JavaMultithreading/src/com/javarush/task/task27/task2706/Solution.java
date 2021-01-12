package com.javarush.task.task27.task2706;

/* 
Убираем deadlock
*/

import java.util.Collections;

public class Solution {
    public void safeMethod(Object obj1, Object obj2) {
        Object objMax;
        if (obj1.toString().compareTo(obj2.toString()) > 0) {
            objMax = obj1;
        } else {
            objMax = obj2;
        }
        Object objMin;
        if (obj1.toString().compareTo(obj2.toString()) < 0) {
            objMin = obj1;
        } else {
            objMin = obj2;
        }


        synchronized (objMax) {
            longTimeMethod();
            synchronized (objMin) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}
