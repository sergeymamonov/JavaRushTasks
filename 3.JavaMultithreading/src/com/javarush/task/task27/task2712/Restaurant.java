package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static List<Tablet> tabletList = new ArrayList<>();
    private static final StatisticManager STATISTIC_MANAGER = StatisticManager.getInstance();
    private final static LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        Cook cook1 = new Cook("Sergey");
        Cook cook2 = new Cook("Katya");

        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);
        cook1.setQueue(ORDER_QUEUE);
        cook2.setQueue(ORDER_QUEUE);
        
        for (int i = 1; i <= 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(ORDER_QUEUE);
            tablets.add(tablet);
        }
        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
