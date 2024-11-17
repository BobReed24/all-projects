package com.thealgorithms.maths;

public final class Perimeter {
    private Perimeter() {
    }

    public static float perimeterRegularPolygon(int n, float side) {
        return n * side;
    }

    public static float perimeterIrregularPolygon(float side1, float side2, float side3, float... sides) {
        float perimeter = side1 + side2 + side3;
        for (float side : sides) {
            perimeter += side;
        }
        return perimeter;
    }

    public static float perimeterRectangle(float length, float breadth) {
        return 2 * (length + breadth);
    }

    public static double perimeterCircle(float r) {
        return 2 * Math.PI * r;
    }
}
