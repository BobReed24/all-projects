package com.thealgorithms.datastructures.heaps;

public class HeapElement {

    private final double key;
    private final Object additionalInfo;

    public HeapElement(double key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }

    public HeapElement(int key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }

    public HeapElement(Integer key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }

    public HeapElement(Double key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }

    public HeapElement(double key) {
        this.key = key;
        this.additionalInfo = null;
    }

    public HeapElement(int key) {
        this.key = key;
        this.additionalInfo = null;
    }

    public HeapElement(Integer key) {
        this.key = key;
        this.additionalInfo = null;
    }

    public HeapElement(Double key) {
        this.key = key;
        this.additionalInfo = null;
    }

    public Object getInfo() {
        return additionalInfo;
    }

    public double getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Key: " + key + " - " + (additionalInfo != null ? additionalInfo.toString() : "No additional info");
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof HeapElement otherHeapElement) {
            return this.key == otherHeapElement.key && (this.additionalInfo != null ? this.additionalInfo.equals(otherHeapElement.additionalInfo) : otherHeapElement.additionalInfo == null);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 31 * (int) key;
        result += (additionalInfo != null) ? additionalInfo.hashCode() : 0;
        return result;
    }

    public String getValue() {
        return additionalInfo.toString();
    }
}
