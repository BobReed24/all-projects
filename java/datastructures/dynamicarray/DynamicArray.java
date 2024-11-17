package com.thealgorithms.datastructures.dynamicarray;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DynamicArray<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 16;
    private int size;
    private int modCount; 
    private Object[] elements;

    public DynamicArray(final int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative.");
        }
        this.size = 0;
        this.modCount = 0;
        this.elements = new Object[capacity];
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public void add(final E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
        modCount++; 
    }

    public void put(final int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }
        ensureCapacity(index + 1);
        elements[index] = element;
        if (index >= size) {
            size = index + 1;
        }
        modCount++; 
    }

    @SuppressWarnings("unchecked")
    public E get(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    public E remove(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        @SuppressWarnings("unchecked") E oldElement = (E) elements[index];
        fastRemove(index);
        modCount++; 
        return oldElement;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; 
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicArrayIterator();
    }

    private final class DynamicArrayIterator implements Iterator<E> {

        private int cursor;
        private int expectedModCount;

        DynamicArrayIterator() {
            this.expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            checkForComodification();
            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            checkForComodification();
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            return (E) elements[cursor++];
        }

        @Override
        public void remove() {
            if (cursor <= 0) {
                throw new IllegalStateException("Cannot remove element before calling next()");
            }
            checkForComodification();
            DynamicArray.this.remove(--cursor);
            expectedModCount = modCount;
        }

        private void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            while (hasNext()) {
                action.accept(next());
            }
        }
    }
}
