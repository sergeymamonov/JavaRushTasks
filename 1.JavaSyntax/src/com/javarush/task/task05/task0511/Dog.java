package com.javarush.task.task05.task0511;

/* 
Создать класс Dog
*/

public class Dog {
    private String name;
    private int height;
    private String color;

    public void initialize(String name) {
        this.name = name;
    }

    public void initialize(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public void initialize(String name, int height, String colour) {
        this.name = name;
        this.height = height;
        this.color = colour;
    }

    public static void main(String[] args) {

    }
}
