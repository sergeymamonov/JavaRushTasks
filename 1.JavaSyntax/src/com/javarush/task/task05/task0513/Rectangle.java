package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    private int top;
    private int left;
    private int width = 0;
    private int height = 0;

    public void initialize(int top, int left) {
        this.top = top;
        this.left = left;
    }

    public void initialize(int top, int left, int width, int hight) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = hight;
    }

    public void initialize(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = width;
    }

    public void initialize(Rectangle otherRectangle) {
        this.top = otherRectangle.top;
        this.left = otherRectangle.left;
        this.width = otherRectangle.width;
        this.height = otherRectangle.height;
    }

    public static void main(String[] args) {

    }
}
