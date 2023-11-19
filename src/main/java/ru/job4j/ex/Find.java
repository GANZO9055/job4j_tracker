package ru.job4j.ex;

public class Find {
    public static String get(String[] data, int index) {
        if (index >= data.length || index < 0) {
            throw new IllegalArgumentException("Index out of bound");
        }
        return data[index];
    }
}
