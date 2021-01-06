package com.javarush.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

    public void printUsers() {
        userAnya.printInfo();
        userAnya.printAdditionalInfo();

        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }

    public int calculateAverageAge() {
        User userUra = new User("Юра", "Карп", 28);
        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        int n1 = (base.get() + age / 100);
        int n2 = (int) (n1 * (hasWork ? 1.1 : 0.9));
        int n3 = (int) (n2 * (hasHouse ? 1.1 : 0.9));
        return n3;
    }

    public String getBossName(User user) {
        return user.getBoss();
    }
}