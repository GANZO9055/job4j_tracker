package ru.job4j.collection;

import java.util.Objects;

public class Job implements Comparable<Job> {
    private String name;

    private int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Job{" + name + ", " + priority + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Job job = (Job) object;
        return priority == job.priority && Objects.equals(name, job.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priority);
    }

    @Override
    public int compareTo(Job another) {
        return Integer.compare(priority, another.priority);
    }
}
