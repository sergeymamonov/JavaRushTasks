package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K, V>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (cache.get(key) != null) {
            return cache.get(key);
        } else {
            V newValue = (V) clazz.getConstructor(key.getClass()).newInstance(key);
            cache.put(key, newValue);
            return newValue;
        }
    }

    public boolean put(V obj) {
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            K keyReflected = (K) method.invoke(obj);
            cache.put(keyReflected, obj);
            return true;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
