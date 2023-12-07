package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int lengthMin = Math.min(left.length(), right.length());
        List<Character> leftOne = new ArrayList<>();
        List<Character> rightOne = new ArrayList<>();
        for (int i = 0; i < lengthMin; i++) {
            leftOne.add(left.charAt(i));
        }
        for (int i = 0; i < lengthMin; i++) {
            rightOne.add(right.charAt(i));
        }
        for (int i = 0; i < lengthMin; i++) {
            if (leftOne.get(i) != rightOne.get(i)) {
                return Character.compare(leftOne.get(i), rightOne.get(i));
            }
        }
        return left.length() - right.length();
    }
}
