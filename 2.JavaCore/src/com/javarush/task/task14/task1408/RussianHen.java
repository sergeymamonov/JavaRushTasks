package com.javarush.task.task14.task1408;

import com.javarush.task.task14.task1408.Country;
import com.javarush.task.task14.task1408.Hen;

public class RussianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 1;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
