package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            int startNumSeconds = numSeconds;
            try {
                while (!interrupted() && numSeconds > 0) {
                    System.out.println(numSeconds);
                    numSeconds--;
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (startNumSeconds > 3.5) {
                System.out.println("Прервано!");
            }
            else {
                System.out.println("Марш!");
            }
        }
    }
}
