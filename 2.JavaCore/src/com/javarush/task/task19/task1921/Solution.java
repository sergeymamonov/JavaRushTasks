package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] info = line.split("(?<=\\D)\\s(?=[0-9\\s])");
                String name = info[0];
                Date date = null;
                try {
                    date = new SimpleDateFormat("dd MM yyyy").parse(info[1]);
                } catch (ParseException p) {
                }
                PEOPLE.add(new Person(name, date));
            }
            bufferedReader.close();
        } catch (IOException e) {

        }
    }
}
