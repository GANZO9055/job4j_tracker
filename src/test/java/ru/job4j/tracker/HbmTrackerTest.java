package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HbmTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenAddNewItemThenReplaceIdAndNameItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test1");
            tracker.add(item);
            var result = tracker.replace(item.getId(), new Item("test2"));
            assertThat(tracker.findById(item.getId()).getName()).isEqualTo("test2");
            assertThat(result).isTrue();
        }
    }

    @Test
    public void whenAddNewItemThenDeleteItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item(1, "test1");
            tracker.add(item);
            tracker.delete(item.getId());
            assertThat(tracker.findById(item.getId())).isNull();
        }
    }

    @Test
    public void whenAddNewItemsThenDeleteAll() {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("test1");
            Item item2 = new Item("test2");
            Item item3 = new Item("test3");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            tracker.deleteAll();
            assertThat(tracker.findAll()).isEmpty();
        }
    }

    @Test
    public void whenAddNewItemsThenFindAll() {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("test1");
            Item item2 = new Item("test2");
            Item item3 = new Item("test3");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            assertThat(tracker.findAll()).isEqualTo(List.of(item1, item2, item3));
        }
    }

    @Test
    public void whenAddNewItemsThenFindByName() {
        try (var tracker = new HbmTracker()) {
            tracker.deleteAll();
            Item item1 = new Item("test1");
            Item item2 = new Item("test2");
            Item item3 = new Item("test2");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            assertThat(tracker.findByName("test2")).isEqualTo(List.of(item2, item3));
        }
    }
}