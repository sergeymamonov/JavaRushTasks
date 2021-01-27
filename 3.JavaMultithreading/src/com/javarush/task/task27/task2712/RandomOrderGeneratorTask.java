package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tabletList;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tabletList = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true) {
            Tablet tablet = tabletList.get((int) (Math.random() * tabletList.size()));
            tablet.createTestOrder();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
