package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int lengthMin = Math.min(left.length(), right.length());
        for (int i = 0; i < lengthMin; i++) {
            char leftOne = left.charAt(i);
            char rightOne = right.charAt(i);
            if (leftOne != rightOne) {
                return Character.compare(leftOne, rightOne);
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
