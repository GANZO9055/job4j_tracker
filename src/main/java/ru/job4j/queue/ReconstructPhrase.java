package ru.job4j.queue;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder elements = new StringBuilder();
        LinkedList<Character> one = (LinkedList<Character>) evenElements;
        for (int i = 0; i < evenElements.size(); i++) {
            if (i % 2 == 0) {
                elements.append(one.get(i));
            }
        }
        return elements.toString();
    }

    private String getDescendingElements() {
        StringBuilder elements = new StringBuilder();
        LinkedList<Character> one = (LinkedList<Character>) descendingElements;
        for (int i = 0; i < descendingElements.size(); i++) {
            elements.append(one.get(descendingElements.size() - i - 1));
        }
        return elements.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
