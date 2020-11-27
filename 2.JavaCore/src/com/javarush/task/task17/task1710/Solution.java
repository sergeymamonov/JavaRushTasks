package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        try {
            switch (args[0]) {
                case ("-c"):
                    create(args[1], args[2], args[3]);
                    break;
                case ("-u"):
                    update(args[1], args[2], args[3], args[4]);
                    break;
                case ("-d"):
                    delete(args[1]);
                    break;
                case ("-i"):
                    info(args[1]);
                    break;
            }
        } catch (Exception e) {
        }
    }

    public static void create(String name, String sexStr, String birthDate) {
        SimpleDateFormat oldFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            if (sexStr.equals("м")) {
                allPeople.add(Person.createMale(name, oldFormat.parse(birthDate)));
            } else {
                allPeople.add(Person.createFemale(name, oldFormat.parse(birthDate)));
            }
        } catch (ParseException e) {
        }
        System.out.println(allPeople.size() - 1);
    }

    public static void update(String index, String name, String sexStr, String birthDate) {
        int i = Integer.parseInt(index);
        SimpleDateFormat oldFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        try {
        if (sexStr.equals("м")) {
            allPeople.remove(i);
            allPeople.add(i, Person.createMale(name, oldFormat.parse(birthDate)));
        } else {
            allPeople.remove(i);
            allPeople.add(i, Person.createFemale(name, oldFormat.parse(birthDate)));
        }
        } catch (ParseException e) {
        }
    }

    public static void delete(String index) {
        int i = Integer.parseInt(index);
        allPeople.remove(i);
        Person nullPerson = Person.createFemale(null, null);
        nullPerson.setSex(null);
        allPeople.add(i, nullPerson);
    }

    public static void info(String index) {
        int i = Integer.parseInt(index);
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String str1;
        if (allPeople.get(i).getSex().equals(Sex.FEMALE)) {
            str1 = "ж";
        }
        else {
            str1 = "м";
        }

        System.out.println(allPeople.get(i).getName() + " " + str1 + " " + format1.format(allPeople.get(i).getBirthDate()));
    }
}
