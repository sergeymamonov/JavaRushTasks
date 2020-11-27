package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            TreeSet<String> stringSet = new TreeSet<>();

            Stream<String> stream = reader.lines();
            stringSet.addAll(stream.map(s -> s.split(""))
                    .flatMap(Arrays::stream)
                    .filter(c -> c.toLowerCase().matches("[a-z]"))
                    .collect(Collectors.toSet()));

            stringSet.stream().limit(5).forEach(System.out::print);
        }
    }
}
