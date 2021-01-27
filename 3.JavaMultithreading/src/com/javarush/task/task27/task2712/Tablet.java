package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private LinkedBlockingQueue queue;
    private final int number;
    private static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public void createTestOrder() {
        TestOrder order = null;
        try {
            order = new TestOrder(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        processOrder(order);
    }

    private void processOrder(Order order) {
        if (!order.isEmpty()) {
            try {
                AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                advertisementManager.processVideos();
                ConsoleHelper.writeMessage(order.toString());
                queue.add(order);
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, String.format("No video is available for the order %s", order));
            }
        }
    }

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }
}
