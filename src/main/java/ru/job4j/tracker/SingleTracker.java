package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {
    private MemTracker memTracker = new MemTracker();
    private static SingleTracker singleton = null;

    private SingleTracker() {
    }

    public static SingleTracker getSingleton() {
        if (singleton == null) {
            singleton = new SingleTracker();
        }
        return singleton;
    }

    public Item add(Item item) {
        return memTracker.add(item);
    }

    public List<Item> findAll() {
        return memTracker.findAll();
    }

    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    public void delete(int id) {
        memTracker.delete(id);
    }
}
