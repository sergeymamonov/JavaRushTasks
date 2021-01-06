package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            if (loadWheelNamesFromDB() == null || loadWheelNamesFromDB().length < 4 || loadWheelNamesFromDB().length > 4) {
                throw new IllegalArgumentException();
            }
            wheels = new ArrayList<>();
            Set<String> wheelSet = new HashSet<>();
            for (int i = 0; i < Wheel.values().length; i++) {
                wheelSet.add(Wheel.values()[i].toString());
            }
            for (String wheelStr : loadWheelNamesFromDB()) {
                if (wheelSet.contains(wheelStr)) {
                    wheels.add(Wheel.valueOf(wheelStr));
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
