package com.javarush.task.task15.task1518;

/* 
Статики и котики
*/

public class Solution {
    public static Cat cat;

    static {
        Solution.cat = new Cat();
        Solution.cat.name = "Vasiliy";
        System.out.println(Solution.cat.name);
    }

    public static void main(String[] args) {

    }

    public static class Cat {
        public String name;
    }

}
