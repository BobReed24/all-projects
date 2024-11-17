package com.thealgorithms.geometry;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MidpointCircleTest {

    @ParameterizedTest
    @CsvSource({
        "0, 0, 3", 
        "10, 10, 2" 
    })
    void
    testGenerateCirclePoints(int centerX, int centerY, int radius) {
        List<int[]> points = MidpointCircle.generateCirclePoints(centerX, centerY, radius);

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            int dx = x - centerX;
            int dy = y - centerY;
            int distanceSquared = dx * dx + dy * dy;

            assertTrue(Math.abs(distanceSquared - radius * radius) <= 1, "Point (" + x + ", " + y + ") does not satisfy the circle equation.");
        }
    }

    @Test
    void testZeroRadiusCircle() {
        List<int[]> points = MidpointCircle.generateCirclePoints(0, 0, 0);

        assertTrue(points.size() == 1 && points.get(0)[0] == 0 && points.get(0)[1] == 0, "Zero-radius circle did not generate the correct point.");
    }
}
