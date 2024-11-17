package com.thealgorithms.misc;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class MapReduce {
    private MapReduce() {
    }
    
    public static String mapreduce(String sentence) {
        List<String> wordList = Arrays.stream(sentence.split(" ")).toList();

        Map<String, Long> wordCounts = wordList.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        StringBuilder result = new StringBuilder();
        wordCounts.forEach((word, count) -> result.append(word).append(": ").append(count).append(","));

        if (!result.isEmpty()) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}
