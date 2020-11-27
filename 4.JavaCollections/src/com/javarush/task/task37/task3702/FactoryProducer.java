package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

public class FactoryProducer {
    public static enum HumanFactoryType {
        FEMALE,
        MALE
    }

    public static AbstractFactory getFactory(HumanFactoryType type) {
        if (HumanFactoryType.MALE.equals(type)) {
            return new MaleFactory();
        }
        if (HumanFactoryType.FEMALE.equals(type)) {
            return new FemaleFactory();
        }
        return null;
    }
}
