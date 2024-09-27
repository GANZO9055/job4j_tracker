package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByIdTest {

    @Test
    public void whenItemWasFindByIdSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("item");
        tracker.add(item);
        FindById findById = new FindById(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        findById.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявки по id ===" + ln
                        + item + ln
        );
    }

    @Test
    public void whenItemWasFindByIdUnsuccessful() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("item");
        tracker.add(item);
        FindById findById = new FindById(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(3);

        findById.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявки по id ===" + ln
                        + "Заявка с введенным id: 3 не найдена." + ln
        );
    }
}