package com.thealgorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.List;

public class MinHeap implements Heap {

    private final List<HeapElement> minHeap;

    public MinHeap(List<HeapElement> listElements) {
        if (listElements == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }

        minHeap = new ArrayList<>();

        for (HeapElement heapElement : listElements) {
            if (heapElement != null) {
                minHeap.add(heapElement);
            } else {
                System.out.println("Null element. Not added to heap");
            }
        }

        for (int i = minHeap.size() / 2; i >= 0; i--) {
            heapifyDown(i + 1);
        }

        if (minHeap.isEmpty()) {
            System.out.println("No element has been added, empty heap.");
        }
    }

    public HeapElement getElement(int elementIndex) {
        if ((elementIndex <= 0) || (elementIndex > minHeap.size())) {
            throw new IndexOutOfBoundsException("Index " + elementIndex + " is out of heap range [1, " + minHeap.size() + "]");
        }
        return minHeap.get(elementIndex - 1);
    }

    private double getElementKey(int elementIndex) {
        if ((elementIndex <= 0) || (elementIndex > minHeap.size())) {
            throw new IndexOutOfBoundsException("Index " + elementIndex + " is out of heap range [1, " + minHeap.size() + "]");
        }
        return minHeap.get(elementIndex - 1).getKey();
    }

    private void swap(int index1, int index2) {
        HeapElement temporaryElement = minHeap.get(index1 - 1);
        minHeap.set(index1 - 1, minHeap.get(index2 - 1));
        minHeap.set(index2 - 1, temporaryElement);
    }

    private void heapifyDown(int elementIndex) {
        int smallest = elementIndex - 1; 
        int leftChild = 2 * elementIndex - 1;
        int rightChild = 2 * elementIndex;

        if (leftChild < minHeap.size() && minHeap.get(leftChild).getKey() < minHeap.get(smallest).getKey()) {
            smallest = leftChild;
        }

        if (rightChild < minHeap.size() && minHeap.get(rightChild).getKey() < minHeap.get(smallest).getKey()) {
            smallest = rightChild;
        }

        if (smallest != elementIndex - 1) {
            HeapElement swap = minHeap.get(elementIndex - 1);
            minHeap.set(elementIndex - 1, minHeap.get(smallest));
            minHeap.set(smallest, swap);

            heapifyDown(smallest + 1); 
        }
    }

    private void toggleUp(int elementIndex) {
        if (elementIndex <= 1) {
            return;
        }

        double key = minHeap.get(elementIndex - 1).getKey();
        int parentIndex = (int) Math.floor(elementIndex / 2.0);

        while (elementIndex > 1 && getElementKey(parentIndex) > key) {
            swap(elementIndex, parentIndex);
            elementIndex = parentIndex;
            parentIndex = (int) Math.floor(elementIndex / 2.0);
        }
    }

    private void toggleDown(int elementIndex) {
        double key = minHeap.get(elementIndex - 1).getKey();
        int size = minHeap.size();

        while (true) {
            int smallest = elementIndex;
            int leftChild = 2 * elementIndex;
            int rightChild = 2 * elementIndex + 1;

            if (leftChild <= size && getElementKey(leftChild) < key) {
                smallest = leftChild;
            }

            if (rightChild <= size && getElementKey(rightChild) < getElementKey(smallest)) {
                smallest = rightChild;
            }

            if (smallest == elementIndex) {
                break;
            }

            swap(elementIndex, smallest);
            elementIndex = smallest;
        }
    }

    private HeapElement extractMin() throws EmptyHeapException {
        if (minHeap.isEmpty()) {
            throw new EmptyHeapException("Cannot extract from empty heap");
        }
        HeapElement result = minHeap.getFirst();
        deleteElement(1);
        return result;
    }

    @Override
    public void insertElement(HeapElement element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot insert null element");
        }
        minHeap.add(element);
        toggleUp(minHeap.size());
    }

    @Override
    public void deleteElement(int elementIndex) throws EmptyHeapException {
        if (minHeap.isEmpty()) {
            throw new EmptyHeapException("Cannot delete from empty heap");
        }
        if ((elementIndex > minHeap.size()) || (elementIndex <= 0)) {
            throw new IndexOutOfBoundsException("Index " + elementIndex + " is out of heap range [1, " + minHeap.size() + "]");
        }

        minHeap.set(elementIndex - 1, minHeap.getLast());
        minHeap.removeLast();

        if (!minHeap.isEmpty() && elementIndex <= minHeap.size()) {
            
            if (elementIndex > 1 && getElementKey(elementIndex) < getElementKey((int) Math.floor(elementIndex / 2.0))) {
                toggleUp(elementIndex);
            } else {
                toggleDown(elementIndex);
            }
        }
    }

    @Override
    public HeapElement getElement() throws EmptyHeapException {
        return extractMin();
    }

    public int size() {
        return minHeap.size();
    }

    public boolean isEmpty() {
        return minHeap.isEmpty();
    }
}
