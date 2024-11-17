package com.thealgorithms.scheduling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MLFQSchedulerTest {

    @Test
    void testMLFQScheduling() {
        
        int[] timeQuantums = {4, 8, 12}; 
        MLFQScheduler scheduler = new MLFQScheduler(3, timeQuantums);

        scheduler.addProcess(new Process(1, 10, 0)); 
        scheduler.addProcess(new Process(2, 15, 0)); 
        scheduler.addProcess(new Process(3, 25, 0)); 

        scheduler.run();

        assertEquals(50, scheduler.getCurrentTime());
    }

    @Test
    void testProcessCompletionOrder() {
        int[] timeQuantums = {3, 6, 9};
        MLFQScheduler scheduler = new MLFQScheduler(3, timeQuantums);

        Process p1 = new Process(1, 10, 0);
        Process p2 = new Process(2, 5, 0);
        Process p3 = new Process(3, 20, 0);

        scheduler.addProcess(p1);
        scheduler.addProcess(p2);
        scheduler.addProcess(p3);

        scheduler.run();

        assertEquals(35, scheduler.getCurrentTime());
    }
}
