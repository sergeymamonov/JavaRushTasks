package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return values().size();
    }

    @Override
    public V put(K key, V value) {
        if (!map.containsKey(key)) {
            List<V> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
            return null;
        }
        V returnedElement = map.get(key).get(map.get(key).size()-1);
        if (map.get(key).size() == repeatCount) {
            map.get(key).remove(0);
        }
        map.get(key).add(value);
        return returnedElement;
    }

    @Override
    public V remove(Object key) {
        if (!map.containsKey(key)) {
            return null;
        }
        V removedElement = map.get(key).get(0);
        if (map.get(key).size() > 1) {
            map.get(key).remove(0);
        } else {
            map.remove(key);
        }
        return removedElement;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> list = new ArrayList<>();
        for (K key : keySet()) {
            list.addAll(map.get(key));
        }
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}