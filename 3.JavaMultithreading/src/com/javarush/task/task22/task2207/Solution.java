package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> words = new ArrayList<>();
        String filename = null;
        try {
            filename = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(filename);
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] wordsInLine = line.split(" ");
                for (String word : wordsInLine) {
                    words.add(word);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> usedWords = new ArrayList<>();
        StringBuilder stringBuilder;
        for (int i = 0; i < words.size() - 1; i++) {
            if (usedWords.contains(i)) {
                continue;
            }
            for (int j = i + 1; j < words.size(); j++) {
                stringBuilder = new StringBuilder(words.get(j));
                if (words.get(i).equals(stringBuilder.reverse().toString())) {
                    usedWords.add(j);
                    result.add(new Pair(words.get(i), words.get(j)));

                    break;
                }
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
}
