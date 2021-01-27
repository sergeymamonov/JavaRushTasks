package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        dishes = new ArrayList<>();
        Dish[] dishesList = Dish.values();
        for (int i = 0; i < dishesList.length; i++) {
            int numberDishes = (int) (Math.random() * dishesList.length);
            dishes.add(dishesList[numberDishes]);
        }
    }
}
