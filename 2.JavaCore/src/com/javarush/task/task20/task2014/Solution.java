package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println(new Solution(4));

        Solution savedObject = new Solution(5);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Study\\Java_study\\Example.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(savedObject);
        outputStream.close();
        fileOutputStream.close();

        FileInputStream filterInputStream = new FileInputStream("C:\\Study\\Java_study\\Example.txt");
        ObjectInputStream inputStream = new ObjectInputStream(filterInputStream);
        Object loadObject = (Solution) inputStream.readObject();
        inputStream.close();
        filterInputStream.close();

        System.out.println(savedObject.toString().equals(loadObject.toString()));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
