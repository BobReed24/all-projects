package com.thealgorithms.datastructures.crdt;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ORSet<T> {

    private final Set<Pair<T>> elements;
    private final Set<Pair<T>> tombstones;

    public ORSet() {
        this.elements = new HashSet<>();
        this.tombstones = new HashSet<>();
    }

    public boolean contains(T element) {
        return elements.stream().anyMatch(pair -> pair.getElement().equals(element));
    }

    public Set<T> elements() {
        Set<T> result = new HashSet<>();
        elements.forEach(pair -> result.add(pair.getElement()));
        return result;
    }

    public void add(T element) {
        String n = prepare();
        effect(element, n);
    }

    public void remove(T element) {
        Set<Pair<T>> pairsToRemove = prepare(element);
        effect(pairsToRemove);
    }

    private Set<Pair<T>> prepare(T element) {
        Set<Pair<T>> pairsToRemove = new HashSet<>();
        for (Pair<T> pair : elements) {
            if (pair.getElement().equals(element)) {
                pairsToRemove.add(pair);
            }
        }
        return pairsToRemove;
    }

    private String prepare() {
        return generateUniqueTag();
    }

    private void effect(T element, String n) {
        Pair<T> pair = new Pair<>(element, n);
        elements.add(pair);
        elements.removeAll(tombstones);
    }

    private void effect(Set<Pair<T>> pairsToRemove) {
        elements.removeAll(pairsToRemove);
        tombstones.addAll(pairsToRemove);
    }

    private String generateUniqueTag() {
        return UUID.randomUUID().toString();
    }

    public boolean compare(ORSet<T> other) {
        Set<Pair<T>> union = new HashSet<>(elements);
        union.addAll(tombstones);

        Set<Pair<T>> otherUnion = new HashSet<>(other.elements);
        otherUnion.addAll(other.tombstones);

        return otherUnion.containsAll(union) && other.tombstones.containsAll(tombstones);
    }

    public void merge(ORSet<T> other) {
        elements.removeAll(other.tombstones);
        other.elements.removeAll(tombstones);
        elements.addAll(other.elements);
        tombstones.addAll(other.tombstones);
    }

    public static class Pair<T> {
        private final T element;
        private final String uniqueTag;

        public Pair(T element, String uniqueTag) {
            this.element = element;
            this.uniqueTag = uniqueTag;
        }

        public T getElement() {
            return element;
        }
    }
}
