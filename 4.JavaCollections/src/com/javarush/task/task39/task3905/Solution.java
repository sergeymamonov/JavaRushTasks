package com.javarush.task.task39.task3905;

import java.util.Random;
import static com.javarush.task.task39.task3905.Color.*;

/* 
Залей меня полностью
*/

public class Solution {
    public static void main(String[] args) {
        Color[][] image = new Color[][] {{Color.BLUE}
        };

        new PhotoPaint().paintFill(image, 0, 0, Color.ORANGE);

        System.out.println(image[0][0].name());

//        Color[][] image = new Color[][]{
//                {BLUE, ORANGE, BLUE, BLUE, BLUE, BLUE},
//                {ORANGE, BLUE, BLUE, BLUE, BLUE, BLUE},
//                {BLUE, BLUE, BLUE, BLUE, BLUE, BLUE},
//                {BLUE, BLUE, YELLOW, YELLOW, BLUE, BLUE},
//                {BLUE, BLUE, BLUE, BLUE, BLUE, BLUE},
//                {BLUE, BLUE, BLUE, BLUE, BLUE, BLUE},
//                {BLUE, null, BLUE, BLUE, BLUE, BLUE},
//                {BLUE, BLUE, BLUE, BLUE, BLUE, BLUE},
//        };
//        new PhotoPaint().paintFill(image, 3, 2, YELLOW);
//
//        for (Color[] colors : image) {
//            for (Color color : colors) {
//                System.out.print(color + "\t\t");
//            }
//            System.out.println();
//
//        }
    }
}
