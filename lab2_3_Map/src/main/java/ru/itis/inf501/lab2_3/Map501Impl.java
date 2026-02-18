package ru.itis.inf501.lab2_3;

public class Map501Impl<K, V> implements Map501<K, V> {

    private int size;
    private Entry501<K, V>[] entries = new Entry501[5];

    private class Entry501Impl<K, V> implements Entry501<K, V> {

        K key;
        V value;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public String toString() {
            return key + " : " + value;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        Entry501Impl entry = new Entry501Impl();
        entry.key = key;
        entry.value = value;

        entries[0] = entry;
        size = 1;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public Set501<K> getKeySet() {
        return null;
    }

    @Override
    public List501<V> getValues() {
        return null;
    }

    @Override
    public List501<Entry501<K, V>> getEntries() {
        List501<Entry501<K, V>> lst = new List501Impl<>();
        for (int i = 0; i < size; ++i) {
            lst.add(entries[i]);
        }
        return lst;
    }
}
