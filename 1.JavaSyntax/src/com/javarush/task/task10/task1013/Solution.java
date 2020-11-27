package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int age;
        private boolean sex;
        private String name;
        private String lastName;
        private String hairColor;
        private int heigh;

        public Human() {
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        //5
        public Human(String name, int age, boolean sex, String hairColor) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.hairColor = hairColor;
        }

        public Human(String name, int age, boolean sex, String hairColor, String lastName) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.hairColor = hairColor;
            this.lastName = lastName;
        }

        public Human(String name, int age, boolean sex, String hairColor, String lastName, int heigh) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.hairColor = hairColor;
            this.lastName = lastName;
            this.heigh = heigh;
        }

        //8
        public Human(String name, boolean sex, String hairColor, String lastName, int heigh) {
            this.name = name;
            this.sex = sex;
            this.hairColor = hairColor;
            this.lastName = lastName;
            this.heigh = heigh;
        }

        public Human(String name, int age, String hairColor, String lastName, int heigh) {
            this.name = name;
            this.age = age;
            this.hairColor = hairColor;
            this.lastName = lastName;
            this.heigh = heigh;
        }

        public Human(String name, int age, boolean sex, String lastName, int heigh) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.lastName = lastName;
            this.heigh = heigh;
        }

    }
}
