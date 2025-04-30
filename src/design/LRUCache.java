package design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LRUCache {

    int capacity;
    Map<Integer, Integer> map;
    LinkedHashSet<Integer> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new LinkedHashSet<>();
    }

    public int get(int key) {
        Integer val = map.get(key);
        if (val != null) {
            list.remove(key);
            list.addLast(key);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        boolean exists = map.containsKey(key);
        if (map.size() == capacity && !exists) {
            Integer keyToRemove = list.removeFirst();
            map.remove(keyToRemove);
        }
        map.put(key, value);
        if (exists) {
            list.remove(key);
        }
        list.addLast(key);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
    }
}

