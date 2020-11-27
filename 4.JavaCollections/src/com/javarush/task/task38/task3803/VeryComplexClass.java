package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = Integer.valueOf(42);
        String string = (String) object;
    }

    public void methodThrowsNullPointerException() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(null);
        int i = (int) arrayList.get(0);
    }

    public static void main(String[] args) {

    }
}
