package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    int indexFor(int hash, int length) {
        return hash & (length-1);
    }

    Entry getEntry(Long key) {
        int hash = (key == null) ? 0 : hash((long) key.hashCode());
        for (Entry entry = table[indexFor(hash, table.length)];
             entry != null;
             entry = entry.next) {
            Object k;
            if (entry.hash == hash &&
                    ((k = entry.key) == key || (key != null && key.equals(k))))
                return entry;
        }
        return null;
    }

    void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == (1 << 30)) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    void transfer(Entry[] newTable) {
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        if (size++ >= threshold)
            resize(2 * table.length);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null)
            return false;
        for (Entry aTable : table) {
            for (Entry e = aTable; e != null; e = e.next)
                if (value.equals(e.value))
                    return true;
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        addEntry(hash(key), key, value, indexFor(hash(key),table.length));
    }

    @Override
    public Long getKey(String value) {
        for (Entry aTable : table) {
            for (Entry e = aTable; e != null; e = e.next)
                if (value.equals(e.value)) {
                return e.key;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return null == getEntry(key) ? null : getEntry(key).getValue();
    }
}