package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    private int top;
    private int left;
    private int width = 0;
    private int height = 0;

    public Rectangle(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int top, int left) {
        this.top = top;
        this.left = left;
    }

    public Rectangle(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = width;
    }

    public Rectangle(Rectangle otherRectangle) {
        this.top = otherRectangle.top;
        this.left = otherRectangle.left;
        this.width = otherRectangle.width;
        this.height = otherRectangle.height;
    }

    public static void main(String[] args) {

    }
}
