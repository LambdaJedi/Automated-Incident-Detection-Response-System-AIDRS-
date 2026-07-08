package org.example;

import java.util.LinkedHashMap;

public class DefaultLruCache extends LinkedHashMap<Integer, Integer>
        implements LruCache {

    private int capacity;

    public DefaultLruCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }


    @Override
    public int get(int key) {
        Integer value = super.get(key);
        if (value == null) {
            return -1;
        }
        return super.get(key);
    }

    @Override
    public void put(int key, int value) {
            super.put(key, value);
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    protected boolean  removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;

    }

    public static void main(String[] args) {
        DefaultLruCache cache = new DefaultLruCache(10);
        cache.put(1, 1); // cache is {1=1}
        cache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(cache.get(1)); // return 1
        cache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(cache.get(1)); // return -1 (not found)
        System.out.println(cache.get(3)); // return 3
        System.out.println(cache.get(4)); // return 4
    }


}


