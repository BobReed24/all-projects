package com.thealgorithms.datastructures.queues;

import java.util.ArrayList;
import java.util.List;

public class GenericArrayListQueue<T> {

    private final List<T> elementList = new ArrayList<>();

    public boolean isEmpty() {
        return elementList.isEmpty();
    }

    public T peek() {
        return isEmpty() ? null : elementList.getFirst();
    }

    public boolean add(T element) {
        return elementList.add(element);
    }

    public T poll() {
        return isEmpty() ? null : elementList.removeFirst();
    }
}
