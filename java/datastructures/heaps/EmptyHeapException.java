package com.thealgorithms.datastructures.heaps;

@SuppressWarnings("serial")
public class EmptyHeapException extends Exception {

    public EmptyHeapException(String message) {
        super(message);
    }

    public EmptyHeapException(String message, Throwable cause) {
        super(message, cause);
    }
}
