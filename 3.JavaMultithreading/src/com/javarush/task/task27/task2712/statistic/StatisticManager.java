package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatisticManager {
    public static SimpleDateFormat parser = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    public static Logger logger = Logger.getLogger(StatisticManager.class.getName());
    private static StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public TreeMap<Date, Long> getProfitForDay() {
        TreeMap<Date, Long> result = new TreeMap<>(Collections.reverseOrder());
        List<VideoSelectedEventDataRow> eventDataRows = statisticStorage.getStorage(EventType.SELECTED_VIDEOS);

        eventDataRows.forEach(selectedVideo -> result.merge(dateFormatted(selectedVideo.getDate()),
                selectedVideo.getAmount(), Long::sum));

        return result;
    }

    private Date dateFormatted(Date date) {
        try {
            return parser.parse(parser.format(date));
        } catch (Exception e) {
            logger.log(Level.INFO, "unparseable date " + date);
        }
        return date;
    }

    public TreeMap<Date, TreeMap<String, Integer>> getCookWorkTimeForDay() {
        List<CookedOrderEventDataRow> eventDataRows = statisticStorage.getStorage(EventType.COOKED_ORDER);
        TreeMap<Date, TreeMap<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());

        Function<CookedOrderEventDataRow, TreeMap<String, Integer>> getTreeMap = (cookedOrder) -> {
            TreeMap<String, Integer> map = new TreeMap<>();
            map.put(cookedOrder.getCookName(), cookedOrder.getTime());
            return map;
        };

        BiFunction<TreeMap<String, Integer>, TreeMap<String, Integer>, TreeMap<String, Integer>> getRes = (c1, c2) -> {
            c2.forEach((name, cookedTime) -> c1.merge(name, cookedTime, Integer::sum));
            return c1;
        };

        eventDataRows.forEach(cookedOrder ->
                result.merge(dateFormatted(cookedOrder.getDate()), getTreeMap.apply(cookedOrder), getRes));

        return result;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            if (storage.containsKey(data.getType())) {
                List<EventDataRow> arrayList = storage.get(data.getType());
                arrayList.add(data);
                storage.put(data.getType(), arrayList);
            } else {
                ArrayList<EventDataRow> arrayList = new ArrayList<>();
                arrayList.add(data);
                storage.put(data.getType(), arrayList);
            }
        }

        public <V> List<V> getStorage(EventType type) {
            return (List<V>) storage.get(type);
        }
    }
}
