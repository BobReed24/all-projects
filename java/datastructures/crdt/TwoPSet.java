package com.thealgorithms.datastructures.crdt;

import java.util.HashSet;
import java.util.Set;

public class TwoPSet<T> {
    private final Set<T> setA;
    private final Set<T> setR;

    public TwoPSet() {
        this.setA = new HashSet<>();
        this.setR = new HashSet<>();
    }

    public boolean lookup(T element) {
        return setA.contains(element) && !setR.contains(element);
    }

    public void add(T element) {
        setA.add(element);
    }

    public void remove(T element) {
        if (lookup(element)) {
            setR.add(element);
        }
    }

    public boolean compare(TwoPSet<T> otherSet) {
        return otherSet.setA.containsAll(setA) && otherSet.setR.containsAll(setR);
    }

    public TwoPSet<T> merge(TwoPSet<T> otherSet) {
        TwoPSet<T> mergedSet = new TwoPSet<>();
        mergedSet.setA.addAll(this.setA);
        mergedSet.setA.addAll(otherSet.setA);
        mergedSet.setR.addAll(this.setR);
        mergedSet.setR.addAll(otherSet.setR);
        return mergedSet;
    }
}
