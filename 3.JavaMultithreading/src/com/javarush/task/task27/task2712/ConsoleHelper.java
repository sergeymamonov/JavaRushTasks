package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        System.out.println("Выберите блюдо. Для завершения заказа введите exit");
        for (Dish dish : Dish.values()) {
            System.out.println(dish);
        }
        String inputDish;
        List<Dish> dishes = new ArrayList<>();
        List<String> dishesStr = new ArrayList<>();
        for (Dish dish : Dish.values()) {
            dishesStr.add(dish.toString());
        }

        while (true) {
            if ((inputDish = readString()).equalsIgnoreCase("exit")) {
                break;
            }
            if (dishesStr.contains(inputDish)) {
                for (Dish dish : Dish.values()) {
                    if (dish.toString().equalsIgnoreCase(inputDish)) {
                        dishes.add(dish);
                    }
                }
            } else {
                System.out.println(String.format(inputDish + " такого блюда нет в меню"));
            }
        }
        return dishes;
    }
}
