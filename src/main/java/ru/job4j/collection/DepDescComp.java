package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] valueOne = o1.split("/");
        String[] valueTwo = o2.split("/");
        int result = valueTwo[0].compareTo(valueOne[0]);
        return result != 0 ? result : o1.compareTo(o2);
    }
}
