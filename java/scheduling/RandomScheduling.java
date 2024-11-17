package com.thealgorithms.scheduling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class RandomScheduling {

    private final List<String> tasks;
    private final Random random;

    public RandomScheduling(Collection<String> tasks, Random random) {
        this.tasks = new ArrayList<>(tasks);
        this.random = random;
    }

    public List<String> schedule() {
        List<String> shuffledTasks = new ArrayList<>(tasks);
        Collections.shuffle(shuffledTasks, random);
        return shuffledTasks;
    }
}
