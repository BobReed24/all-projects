package com.thealgorithms.maths;

import java.util.stream.StreamSupport;
import org.apache.commons.collections4.IterableUtils;

public final class Means {

    private Means() {
    }

    public static Double arithmetic(final Iterable<Double> numbers) {
        checkIfNotEmpty(numbers);
        return StreamSupport.stream(numbers.spliterator(), false).reduce((x, y) -> x + y).get() / IterableUtils.size(numbers);
    }

    public static Double geometric(final Iterable<Double> numbers) {
        checkIfNotEmpty(numbers);
        return Math.pow(StreamSupport.stream(numbers.spliterator(), false).reduce((x, y) -> x * y).get(), 1d / IterableUtils.size(numbers));
    }

    public static Double harmonic(final Iterable<Double> numbers) {
        checkIfNotEmpty(numbers);
        return IterableUtils.size(numbers) / StreamSupport.stream(numbers.spliterator(), false).reduce(0d, (x, y) -> x + 1d / y);
    }

    private static void checkIfNotEmpty(final Iterable<Double> numbers) {
        if (!numbers.iterator().hasNext()) {
            throw new IllegalArgumentException("Emtpy list given for Mean computation.");
        }
    }
}
