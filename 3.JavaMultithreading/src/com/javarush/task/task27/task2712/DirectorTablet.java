package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    private StatisticManager statisticManager = StatisticManager.getInstance();
    private StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
    private static SimpleDateFormat parser = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit() {
        Double sum = 0d;
        for (Date date : statisticManager.getProfitForDay().keySet()) {
            Double profit = (double) statisticManager.getProfitForDay().get(date) / 100;
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", parser.format(date), profit));
            sum += profit;
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", sum));
    }

    public void printCookWorkloading() {
        for (Date date : statisticManager.getCookWorkTimeForDay().keySet()) {
            TreeMap<String, Integer> treeMap = statisticManager.getCookWorkTimeForDay().get(date);
            ConsoleHelper.writeMessage(parser.format(date));
            for (String cookName : treeMap.keySet()) {
                if (treeMap.get(cookName) != 0) {
                    int workTime = (int) Math.ceil((double) treeMap.get(cookName) / 60);
                    ConsoleHelper.writeMessage(String.format("%s - %d min", cookName, workTime));
                }
            }
        }
    }

    public void printActiveVideoSet()
    {
        List<Advertisement> activeVideoSet = StatisticAdvertisementManager.getInstance().getVideoSet(true);
        for (Advertisement ad : activeVideoSet)
        {
            ConsoleHelper.writeMessage(ad.getName() + " - " + ad.getHits());
        }
    }

    public void printArchivedVideoSet()
    {
        List<Advertisement> activeVideoSet = StatisticAdvertisementManager.getInstance().getVideoSet(false);
        for (Advertisement ad : activeVideoSet)
        {
            ConsoleHelper.writeMessage(ad.getName());
        }
    }}
