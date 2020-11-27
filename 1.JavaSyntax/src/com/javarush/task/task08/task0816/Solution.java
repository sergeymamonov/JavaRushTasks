package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Арни", dateFormat.parse("MAY 1 2013"));
        map.put("Хенс", dateFormat.parse("JUN 1 2014"));
        map.put("Змсворт", dateFormat.parse("JUL 1 2015"));
        map.put("Норрис", dateFormat.parse("MAY 1 2016"));
        map.put("Чан", dateFormat.parse("MAY 1 2017"));
        map.put("Еванс", dateFormat.parse("AUG 1 2010"));
        map.put("Ли", dateFormat.parse("JAN 1 2009"));
        map.put("Мамонов", dateFormat.parse("FEB 1 2008"));
        map.put("Жарков", dateFormat.parse("DEC 1 2007"));

//        DateFormat dateFormatShort = new SimpleDateFormat("MMMMM d", Locale.ENGLISH);
//
//        Date startSummer = dateFormatShort.parse("JUN, 1");

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            int monthNumber = pair.getValue().getMonth() + 1;
            if (monthNumber > 5 && monthNumber < 9) {
//                System.out.println(pair.getKey() + " - " + pair.getValue() + " - " + monthNumber);
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        removeAllSummerPeople(createMap());
    }
}
