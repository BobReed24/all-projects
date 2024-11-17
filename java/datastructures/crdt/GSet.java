package com.thealgorithms.datastructures.crdt;

import java.util.HashSet;
import java.util.Set;

public class GSet<T> {
    private final Set<T> elements;

    public GSet() {
        this.elements = new HashSet<>();
    }

    public void addElement(T e) {
        elements.add(e);
    }

    public boolean lookup(T e) {
        return elements.contains(e);
    }

    public boolean compare(GSet<T> other) {
        return other.elements.containsAll(elements);
    }

    public void merge(GSet<T> other) {
        elements.addAll(other.elements);
    }
}
