package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double maxDistance = 0;
        int horseNumber = 0;
        for (Horse horse : horses) {
            if (horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
                horseNumber = horses.indexOf(horse);
            }
        }
        return horses.get(horseNumber);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Pegas", 3d, 0d));
        horses.add(new Horse("Gnedaya", 3d, 0d));
        horses.add(new Horse("Udacha", 3d, 0d));

        game = new Hippodrome(horses);

        game.run();
        game.printWinner();
    }
}
