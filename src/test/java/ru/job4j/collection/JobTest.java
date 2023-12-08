package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    public void whenCompatorDescByName() {
        List<Job> name = Arrays.asList(
                new Job("Konstantin", 1),
                new Job("Andreey", 2),
                new Job("Dmitriy", 3)
        );
        name.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("Konstantin", 1),
                new Job("Dmitriy", 3),
                new Job("Andreey", 2)
        );
        assertThat(expected).isEqualTo(name);
    }

    @Test
    public void whenCompatorDescByPriority() {
        List<Job> name = Arrays.asList(
                new Job("Konstantin", 1),
                new Job("Andreey", 2),
                new Job("Dmitriy", 3)
        );
        name.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Dmitriy", 3),
                new Job("Andreey", 2),
                new Job("Konstantin", 1)
        );
        assertThat(expected).isEqualTo(name);
    }

    @Test
    public void whenCompatorAscByPriority() {
        List<Job> name = Arrays.asList(
                new Job("Konstantin", 1),
                new Job("Andreey", 2),
                new Job("Dmitriy", 3)
        );
        name.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Konstantin", 1),
                new Job("Andreey", 2),
                new Job("Dmitriy", 3)
        );
        assertThat(expected).isEqualTo(name);
    }

    @Test
    public void whenCompatorAscByName() {
        List<Job> name = Arrays.asList(
                new Job("Konstantin", 1),
                new Job("Andreey", 2),
                new Job("Dmitriy", 3)
        );
        name.sort(new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("Andreey", 2),
                new Job("Dmitriy", 3),
                new Job("Konstantin", 1)
        );
        assertThat(expected).isEqualTo(name);
    }

    @Test
    public void whenCompatorDescByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorAscByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}