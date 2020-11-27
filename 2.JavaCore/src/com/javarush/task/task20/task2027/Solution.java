package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;


/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }



    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> foundWords = new ArrayList<>();

        for (String word : words) {
            char[] letters = word.toCharArray();

            if (letters.length > 0) {
                for (int startY = 0; startY < crossword.length; ++startY) {
                    for (int startX = 0; startX < crossword[startY].length; ++startX) {
                        blockCompareFirstLetter:
                        {
                            if (letters[0] == crossword[startY][startX]) {
                                for (int directionY = -1; directionY <= 1; ++directionY) {
                                    for (int directionX = -1; directionX <= 1; directionX += directionY == 0 ? 2 : 1) {
                                        int endX = startX;
                                        int endY = startY;

                                        blockCompareRestOfWord:
                                        {
                                            for (int letter = 1; letter < letters.length; ++letter) {
                                                if (letters[letter] != crossLetter(crossword, endX += directionX, endY += directionY)) {
                                                    break blockCompareRestOfWord;
                                                }
                                            }

                                            foundWords.add(new Word(word, startX, startY, endX, endY));

                                            if (letters.length == 1) {
                                                break blockCompareFirstLetter;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return foundWords;
    }

    public static int crossLetter(int[][] crossword, int x, int y) {
        return y >= 0 && y < crossword.length && x >= 0 && x < crossword[y].length ? crossword[y][x] : 0;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public Word(String text, int startX, int startY, int endX, int endY) {
            this.text = text;
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
