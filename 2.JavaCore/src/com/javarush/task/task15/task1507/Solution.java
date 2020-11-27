package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }
//1
    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix() {
        System.out.println("Заполняем объектами String");
    }

    public static void printMatrix(String value) {
        System.out.println(value);
    }

    public static void printMatrix(long m, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix((int) m, 5, (Object) value);
    }
//5
    public static void printMatrix(int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(5, n, (Object) value);
    }

    public static void printMatrix(int m, int n) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) "a");
    }

    public static void printMatrix(long m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix((int) m, n, (Object) value);
    }
//8
    public static void printMatrix(long m, long n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix((int) m, (int) n, (Object) value);
    }

    public static void printMatrix(int m, long n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, (int) n, (Object) value);
    }


//10
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
