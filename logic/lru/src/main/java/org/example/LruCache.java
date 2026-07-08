package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public interface LruCache {

    /**
     * @return the value of the key if the key exists,
     * otherwise return -1
     */
    int get(int key);

    /**
     * Update the value of the key if the key exists.
     * Otherwise, add the key-value pair to the cache.
     * If the number of keys exceeds the capacity from this operation,
     * evict the least recently used key.
     */
    void put(int key, int value);

    /**
     * Set the max capacity of the cache
     */
    void setCapacity(int capacity);

}
