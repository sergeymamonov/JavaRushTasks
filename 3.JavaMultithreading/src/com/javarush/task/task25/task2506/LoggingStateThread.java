package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    public void run() {
        Thread.State state = thread.getState();
        System.out.println(state);
        do {
            if (thread.getState() != state) {
                System.out.println(thread.getState());
                state = thread.getState();
            }
        } while (state != State.TERMINATED);
    }
}
