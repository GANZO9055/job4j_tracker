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
        int number = evenElements.size();
        for (int i = 0; i < number; i++) {
            if (i % 2 == 0) {
                elements.append(evenElements.pollFirst());
            } else {
                evenElements.poll();
            }
        }
        return elements.toString();
    }

    private String getDescendingElements() {
        StringBuilder elements = new StringBuilder();
        int number = descendingElements.size();
        for (int i = 0; i < number; i++) {
            elements.append(descendingElements.pollLast());
        }
        return elements.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
