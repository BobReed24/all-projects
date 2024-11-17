package com.thealgorithms.lineclipping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.thealgorithms.lineclipping.utils.Line;
import com.thealgorithms.lineclipping.utils.Point;
import org.junit.jupiter.api.Test;

class CohenSutherlandTest {

    CohenSutherland cs = new CohenSutherland(1.0, 1.0, 10.0, 10.0);

    @Test
    void testLineCompletelyInside() {
        
        Line line = new Line(new Point(2.0, 2.0), new Point(8.0, 8.0));
        Line clippedLine = cs.cohenSutherlandClip(line);

        assertNotNull(clippedLine, "Line should not be null.");
        assertEquals(line, clippedLine, "Line inside the window should remain unchanged.");
    }

    @Test
    void testLineCompletelyOutside() {
        
        Line line = new Line(new Point(11.0, 12.0), new Point(15.0, 18.0));
        Line clippedLine = cs.cohenSutherlandClip(line);

        assertNull(clippedLine, "Line should be null because it's completely outside.");
    }

    @Test
    void testLinePartiallyInside() {
        
        Line line = new Line(new Point(5.0, 5.0), new Point(12.0, 12.0));
        Line expectedClippedLine = new Line(new Point(5.0, 5.0), new Point(10.0, 10.0)); 
        Line clippedLine = cs.cohenSutherlandClip(line);

        assertNotNull(clippedLine, "Line should not be null.");
        assertEquals(expectedClippedLine, clippedLine, "Line should be clipped correctly.");
    }

    @Test
    void testLineOnBoundary() {
        
        Line line = new Line(new Point(1.0, 5.0), new Point(10.0, 5.0));
        Line clippedLine = cs.cohenSutherlandClip(line);

        assertNotNull(clippedLine, "Line should not be null.");
        assertEquals(line, clippedLine, "Line on the boundary should remain unchanged.");
    }

    @Test
    void testDiagonalLineThroughClippingWindow() {
        
        Line line = new Line(new Point(0.0, 0.0), new Point(12.0, 12.0));
        Line expectedClippedLine = new Line(new Point(1.0, 1.0), new Point(10.0, 10.0)); 
        Line clippedLine = cs.cohenSutherlandClip(line);

        assertNotNull(clippedLine, "Line should not be null.");
        assertEquals(expectedClippedLine, clippedLine, "Diagonal line should be clipped correctly.");
    }

    @Test
    void testVerticalLineClipping() {
        
        Line line = new Line(new Point(5.0, 0.0), new Point(5.0, 12.0));
        Line expectedClippedLine = new Line(new Point(5.0, 1.0), new Point(5.0, 10.0)); 
        Line clippedLine = cs.cohenSutherlandClip(line);

        assertNotNull(clippedLine, "Line should not be null.");
        assertEquals(expectedClippedLine, clippedLine, "Vertical line should be clipped correctly.");
    }
}
