package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String[] person = fileScanner.nextLine().split(" ");

            return new Person(person[1], person[2], person[0], new SimpleDateFormat("dd MM yyyy")
                    .parse(String.format("%s %s %s", person[3], person[4], person[5])));
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
