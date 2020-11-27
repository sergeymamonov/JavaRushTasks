package com.javarush.task.task35.task3501;

public class GenericStatic<T extends Integer> {
    public static <T> T someStaticMethod(T genericObject) {
        System.out.println(genericObject);
        return genericObject;
    }
}
