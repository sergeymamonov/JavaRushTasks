package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Long id;
        Long startTime = new Date().getTime();
        for (String s : strings) {
            id = shortener.getId(s);
            ids.add(id);
        }
        Long endTime = new Date().getTime();
        return endTime - startTime;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        String s;
        Long startTime = new Date().getTime();
        for (Long id : ids) {
            s = shortener.getString(id);
            strings.add(s);
        }
        Long endTime = new Date().getTime();
        return endTime - startTime;

    }

    @Test
    public void testHashMapStorage() {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener1 = new Shortener(hashMapStorageStrategy);

        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener2 = new Shortener(hashBiMapStorageStrategy);

        HashSet<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        HashSet<Long> ids = new HashSet<>();
        long timeToGetIds1 = getTimeToGetIds(shortener1, origStrings, ids);
        long timeToGetIds2 = getTimeToGetIds(shortener2, origStrings, ids);

        Assert.assertTrue(timeToGetIds1 > timeToGetIds2);

        HashSet<String> strings = new HashSet<>();
        long timeToGetStrings1 = getTimeToGetStrings(shortener1, ids, strings);
        long timeToGetStrings2 = getTimeToGetStrings(shortener2, ids, strings);

        Assert.assertEquals(timeToGetStrings1, timeToGetStrings2, 30);
    }
}
