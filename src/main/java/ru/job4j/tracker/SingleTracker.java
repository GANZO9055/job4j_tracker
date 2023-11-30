package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {
    private Tracker tracker = new Tracker();
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
        return tracker.add(item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }
}
