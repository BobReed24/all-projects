package com.thealgorithms.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Conway {
    private Conway() {
    }

    private static final StringBuilder BUILDER = new StringBuilder();

    protected static List<String> generateList(String originalString, int maxIteration) {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < maxIteration; i++) {
            originalString = generateNextElement(originalString);
            numbers.add(originalString);
        }
        return numbers;
    }

    public static String generateNextElement(String originalString) {
        BUILDER.setLength(0);
        String[] stp = originalString.split("(?<=(.))(?!\\1)");
        Arrays.stream(stp).forEach(s -> BUILDER.append(s.length()).append(s.charAt(0)));
        return BUILDER.toString();
    }
}
