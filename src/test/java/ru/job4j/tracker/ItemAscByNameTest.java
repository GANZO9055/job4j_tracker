package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    public void whenSortAsc() {
        List<Item> item = Arrays.asList(
                new Item(1, "One"),
                new Item(2, "Two"),
                new Item(3, "Three"),
                new Item(4, "Four")
        );
        item.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(4, "Four"),
                new Item(1, "One"),
                new Item(3, "Three"),
                new Item(2, "Two")
        );
        for (int i = 0; i < expected.size(); i++) {
            assertThat(expected.get(i).getName()).isEqualTo(item.get(i).getName());
        }
    }
}