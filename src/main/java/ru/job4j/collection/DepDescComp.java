package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] valueOne = o1.split("/");
        String[] valueTwo = o2.split("/");
        for (int i = 0; i < Math.min(valueOne.length, valueTwo.length); i++) {
            if (valueTwo[i].compareTo(valueOne[i]) == 0 && i == 0) {
                continue;
            } else if (i == 0) {
                return valueTwo[i].compareTo(valueOne[i]);
            }
            if (valueOne[i].compareTo(valueTwo[i]) == 0) {
                continue;
            }
            return valueOne[i].compareTo(valueTwo[i]);
        }
        return o1.compareTo(o2);
    }
}
