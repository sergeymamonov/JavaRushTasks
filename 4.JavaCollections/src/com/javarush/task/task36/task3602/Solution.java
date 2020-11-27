package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] classes = Collections.class.getDeclaredClasses();
        for (Class<?> clazz : classes) {
            Class superClazz = clazz.getSuperclass();
            ArrayList<Class> arrayOfSuperClasses = new ArrayList<>();
            while (superClazz != null) {
                arrayOfSuperClasses.add(superClazz);
                superClazz = superClazz.getSuperclass();
            }
            for (Class item : arrayOfSuperClasses) {
                Class<?>[] arrayOfInterfaces = item.getInterfaces();
                for (Class<?> declaredInterface : arrayOfInterfaces) {
                    if (declaredInterface.getSimpleName().equals("List")) {
                        Method[] methods = clazz.getMethods();
                        for (Method method : methods) {
                            if (method.getName().equals("get")) {
                                try {
                                    Constructor<?> constructor = clazz.getDeclaredConstructor();
                                    constructor.setAccessible(true);
                                    List<?> emptyList = (List<?>) constructor.newInstance();
                                    emptyList.get(0);
                                } catch (IndexOutOfBoundsException e) {
                                    return clazz;
                                } catch (Exception e) {
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
