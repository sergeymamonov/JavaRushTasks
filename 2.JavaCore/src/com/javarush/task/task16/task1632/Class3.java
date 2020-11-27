package com.javarush.task.task16.task1632;

public class Class3 extends Thread {
    public void run() {
        while (true) {
            System.out.println("Ура");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
