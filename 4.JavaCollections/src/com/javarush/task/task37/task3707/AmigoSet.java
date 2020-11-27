package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<E, Object>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<E, Object>((int) Math.max(16, Math.ceil(collection.size() / .75f)));
        addAll(collection);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(E e) {
        return null == map.put(e, PRESENT);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public Object clone() {
        try {
            AmigoSet copy = (AmigoSet) super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        try {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeInt(map.size());
            objectOutputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
            objectOutputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
            for (E e : map.keySet()) {
                objectOutputStream.writeObject(e);
            }
        } catch (IOException e) {
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        try {
            objectInputStream.defaultReadObject();
            int size = objectInputStream.readInt();
            float loadFactor = objectInputStream.readFloat();
            int capacity = objectInputStream.readInt();

            map = new HashMap<>(capacity, loadFactor);

            for (int i = 0; i < size; i++) {
                map.put((E) objectInputStream.readObject(), PRESENT);
            }
        } catch (ClassNotFoundException | IOException e) {
        }
    }

    @Override
    public boolean equals(Object o) {

        if ((o == null)||!(o instanceof AmigoSet )) return false;

        if (this.hashCode()!= ((AmigoSet)o).hashCode()) return false;
        AmigoSet<E> compare = (AmigoSet)o;
        if (this.map.size()!= compare.map.size()) return false;
        for (E e: map.keySet()){
            if (!compare.contains(e)) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.map.hashCode()*31+PRESENT.hashCode();
    }}
