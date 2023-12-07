package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] one = left.split(". Task.");
        String[] two = right.split(". Task.");
        int numberOne = 0;
        int numberTwo = 0;
        for (int i = 0; i < one.length; i++) {
            numberOne = Integer.parseInt(one[i]);
            numberTwo = Integer.parseInt(two[i]);
        }
        return Integer.compare(numberOne, numberTwo);
    }
}
