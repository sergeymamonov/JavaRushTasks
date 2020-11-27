package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.*;
import java.nio.file.Paths;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        File file = new File("not_existing_file.txt");
        FileInputStream stream = new FileInputStream(file);
    }

    public static void main(String[] args) {

    }
}
