package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    public void whenSortAsc() {
        List<Item> item = Arrays.asList(
                new Item(1, "One"),
                new Item(2, "Two"),
                new Item(3, "Three"),
                new Item(4, "Four")
        );
        item.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "Two"),
                new Item(3, "Three"),
                new Item(1, "One"),
                new Item(4, "Four")
        );
        for (int i = 0; i < expected.size(); i++) {
            assertThat(expected.get(i).getName()).isEqualTo(item.get(i).getName());
        }
    }
}