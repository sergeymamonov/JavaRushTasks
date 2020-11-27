package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int maxSquare(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length + 2][matrix[0].length + 2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[i + 1][j + 1] = matrix[i][j];
            }
        }
        int result = 0;
        for (int i = 1; i < newMatrix.length; i++) {
            for (int j = 1; j < newMatrix[0].length; j++) {
                if (newMatrix[i][j] == 0) {
                    continue;
                }
                newMatrix[i][j] = Math.min(Math.min(newMatrix[i - 1][j - 1], newMatrix[i][j - 1]), newMatrix[i - 1][j]) + 1;
                if (newMatrix[i][j] > result) {
                    result = newMatrix[i][j];
                }
            }
        }
        return result * result;
    }
}
