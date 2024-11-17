package com.thealgorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.HashMap;

public class GenericHeap<T extends Comparable<T>> {

    private final ArrayList<T> data = new ArrayList<>();
    private final HashMap<T, Integer> map = new HashMap<>();

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot insert null into the heap.");
        }

        this.data.add(item);
        map.put(item, this.data.size() - 1);
        upHeapify(this.data.size() - 1);
    }

    private void upHeapify(int ci) {
        int pi = (ci - 1) / 2;
        if (ci > 0 && isLarger(this.data.get(ci), this.data.get(pi)) > 0) {
            swap(pi, ci);
            upHeapify(pi);
        }
    }

    public int size() {
        return this.data.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        this.swap(0, this.size() - 1);
        T rv = this.data.remove(this.size() - 1);
        map.remove(rv);
        downHeapify(0);
        return rv;
    }

    private void downHeapify(int pi) {
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;
        int mini = pi;
        if (lci < this.size() && isLarger(this.data.get(lci), this.data.get(mini)) > 0) {
            mini = lci;
        }
        if (rci < this.size() && isLarger(this.data.get(rci), this.data.get(mini)) > 0) {
            mini = rci;
        }
        if (mini != pi) {
            this.swap(pi, mini);
            downHeapify(mini);
        }
    }

    public T get() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return this.data.getFirst();
    }

    private int isLarger(T t, T o) {
        return t.compareTo(o);
    }

    private void swap(int i, int j) {
        T ith = this.data.get(i);
        T jth = this.data.get(j);
        this.data.set(i, jth);
        this.data.set(j, ith);
        map.put(ith, j);
        map.put(jth, i);
    }

    public void updatePriority(T item) {
        if (!map.containsKey(item)) {
            throw new IllegalArgumentException("Item not found in the heap");
        }
        int index = map.get(item);
        upHeapify(index);
    }
}
