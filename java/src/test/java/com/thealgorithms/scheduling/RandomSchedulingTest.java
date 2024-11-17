package com.thealgorithms.scheduling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomSchedulingTest {

    private RandomScheduling randomScheduling;
    private Random mockRandom;

    @BeforeEach
    public void setup() {
        mockRandom = mock(Random.class); 
    }

    @Test
    public void testRandomOrder1() {
        
        List<String> tasks = List.of("Task1", "Task2", "Task3");
        
        when(mockRandom.nextInt(anyInt())).thenReturn(1, 2, 0);
        randomScheduling = new RandomScheduling(tasks, mockRandom);

        List<String> result = randomScheduling.schedule();

        assertEquals(List.of("Task1", "Task2", "Task3"), result);
    }

    @Test
    public void testRandomOrder2() {
        
        List<String> tasks = List.of("A", "B", "C", "D");
        
        when(mockRandom.nextInt(anyInt())).thenReturn(2, 1, 3, 0);
        randomScheduling = new RandomScheduling(tasks, mockRandom);

        List<String> result = randomScheduling.schedule();

        assertEquals(List.of("A", "C", "B", "D"), result);
    }

    @Test
    public void testSingleTask() {
        
        List<String> tasks = List.of("SingleTask");
        when(mockRandom.nextInt(anyInt())).thenReturn(0); 
        randomScheduling = new RandomScheduling(tasks, mockRandom);

        List<String> result = randomScheduling.schedule();

        assertEquals(List.of("SingleTask"), result);
    }

    @Test
    public void testEmptyTaskList() {
        
        List<String> tasks = List.of();
        randomScheduling = new RandomScheduling(tasks, mockRandom);

        List<String> result = randomScheduling.schedule();

        assertEquals(List.of(), result); 
    }

    @Test
    public void testSameTasksMultipleTimes() {
        
        List<String> tasks = List.of("X", "X", "Y", "Z");
        when(mockRandom.nextInt(anyInt())).thenReturn(3, 0, 1, 2);
        randomScheduling = new RandomScheduling(tasks, mockRandom);

        List<String> result = randomScheduling.schedule();

        assertEquals(List.of("Y", "X", "X", "Z"), result);
    }
}
