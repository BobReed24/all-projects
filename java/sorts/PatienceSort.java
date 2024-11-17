package com.thealgorithms.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PatienceSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        if (array.length == 0) {
            return array;
        }

        final List<List<T>> piles = formPiles(array);
        final PriorityQueue<PileNode<T>> pq = mergePiles(piles);
        extractPiles(array, pq);

        return array;
    }

    private static <T extends Comparable<T>> List<List<T>> formPiles(final T[] array) {
        final List<List<T>> piles = new ArrayList<>();
        final List<T> lastElements = new ArrayList<>();

        for (T x : array) {
            int pos = Collections.binarySearch(lastElements, x);
            if (pos < 0) {
                pos = -pos - 1;
            }

            if (pos < piles.size()) {
                piles.get(pos).add(x);
                lastElements.set(pos, x);
            } else {
                List<T> newPile = new ArrayList<>();
                newPile.add(x);
                piles.add(newPile);
                lastElements.add(x);
            }
        }

        return piles;
    }

    private static <T extends Comparable<T>> PriorityQueue<PileNode<T>> mergePiles(final Iterable<List<T>> piles) {
        PriorityQueue<PileNode<T>> pq = new PriorityQueue<>();
        for (List<T> pile : piles) {
            pq.add(new PileNode<>(pile.removeLast(), pile));
        }
        return pq;
    }

    private static <T extends Comparable<T>> void extractPiles(final T[] array, final PriorityQueue<PileNode<T>> pq) {
        int index = 0;
        while (!pq.isEmpty()) {
            PileNode<T> node = pq.poll();
            array[index++] = node.value;
            if (!node.pile.isEmpty()) {
                pq.add(new PileNode<>(node.pile.removeLast(), node.pile));
            }
        }
    }

    private record PileNode<T extends Comparable<T>>(T value, List<T> pile) implements Comparable<PileNode<T>> {
        @Override
        public int compareTo(PileNode<T> other) {
            return this.value.compareTo(other.value);
        }
    }
}
