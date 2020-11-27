package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Serializable, Cloneable {
    Entry<String> root;
    private ArrayList<Entry> list = new ArrayList<>();


    public CustomTree() {
        this.root = new Entry<String>("0");
        list.add(0, root);
    }

    @Override
    public boolean add(String s) {
        Entry current;
        Entry newEntry = new Entry(s);
        for (int i = 0; i < list.size(); i++) {
            current = list.get(i);
            if (current.isAvailableToAddChildren()) {
                if (current.leftChild == null) {
                    current.leftChild = newEntry;
                } else current.rightChild = newEntry;
                newEntry.parent = current;
                current.checkChildren();
                list.add(newEntry);
                return true;
            }
        }
        return false;
    }


    @Override
    public int size() {
        return list.size() - 1;
    }


    public String getParent(String s) {
        for (Entry<String> item : list) {
            if (item.elementName.equals(s))
                return item.parent.elementName;
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }

        Entry deleteItem = getElementByName(String.valueOf(o));
        Entry parent = deleteItem.parent;

        if(deleteItem.leftChild != null){
            remove(deleteItem.leftChild.elementName);
        }
        if(deleteItem.rightChild != null){
            remove(deleteItem.rightChild.elementName);
        }
        if(deleteItem.leftChild == null && deleteItem.rightChild == null) {
            if (parent.rightChild == deleteItem) {
                parent.rightChild = null;
                parent.availableToAddRightChildren = true;
            } else {
                parent.leftChild = null;
                parent.availableToAddLeftChildren = true;
            }
            list.remove(deleteItem);
        }

        return true;
    }

    public Entry getElementByName(String elementName){
        Entry element = null;
        for(Entry e : list){
            if(e.elementName.equals(elementName))
                element = e;
        }
        return element;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }


    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddRightChildren = true;
            availableToAddLeftChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddRightChildren | availableToAddLeftChildren;
        }

        public void checkChildren() {
            if (leftChild != null) availableToAddLeftChildren = false;
            if (rightChild != null) availableToAddRightChildren = false;
        }
    }
}
