package com.thealgorithms.maths;

public final class Area {
    private Area() {
    }

    private static final String POSITIVE_RADIUS = "Must be a positive radius";

    private static final String POSITIVE_HEIGHT = "Must be a positive height";

    private static final String POSITIVE_BASE = "Must be a positive base";

    public static double surfaceAreaCube(final double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Must be a positive sideLength");
        }
        return 6 * sideLength * sideLength;
    }

    public static double surfaceAreaSphere(final double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(POSITIVE_RADIUS);
        }
        return 4 * Math.PI * radius * radius;
    }

    public static double surfaceAreaRectangle(final double length, final double width) {
        if (length <= 0) {
            throw new IllegalArgumentException("Must be a positive length");
        }
        if (width <= 0) {
            throw new IllegalArgumentException("Must be a positive width");
        }
        return length * width;
    }

    public static double surfaceAreaCylinder(final double radius, final double height) {
        if (radius <= 0) {
            throw new IllegalArgumentException(POSITIVE_RADIUS);
        }
        if (height <= 0) {
            throw new IllegalArgumentException(POSITIVE_RADIUS);
        }
        return 2 * (Math.PI * radius * radius + Math.PI * radius * height);
    }

    public static double surfaceAreaSquare(final double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Must be a positive sideLength");
        }
        return sideLength * sideLength;
    }

    public static double surfaceAreaTriangle(final double base, final double height) {
        if (base <= 0) {
            throw new IllegalArgumentException(POSITIVE_BASE);
        }
        if (height <= 0) {
            throw new IllegalArgumentException(POSITIVE_HEIGHT);
        }
        return base * height / 2;
    }

    public static double surfaceAreaParallelogram(final double base, final double height) {
        if (base <= 0) {
            throw new IllegalArgumentException(POSITIVE_BASE);
        }
        if (height <= 0) {
            throw new IllegalArgumentException(POSITIVE_HEIGHT);
        }
        return base * height;
    }

    public static double surfaceAreaTrapezium(final double base1, final double base2, final double height) {
        if (base1 <= 0) {
            throw new IllegalArgumentException(POSITIVE_BASE + 1);
        }
        if (base2 <= 0) {
            throw new IllegalArgumentException(POSITIVE_BASE + 2);
        }
        if (height <= 0) {
            throw new IllegalArgumentException(POSITIVE_HEIGHT);
        }
        return (base1 + base2) * height / 2;
    }

    public static double surfaceAreaCircle(final double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(POSITIVE_RADIUS);
        }
        return Math.PI * radius * radius;
    }

    public static double surfaceAreaHemisphere(final double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(POSITIVE_RADIUS);
        }
        return 3 * Math.PI * radius * radius;
    }

    public static double surfaceAreaCone(final double radius, final double height) {
        if (radius <= 0) {
            throw new IllegalArgumentException(POSITIVE_RADIUS);
        }
        if (height <= 0) {
            throw new IllegalArgumentException(POSITIVE_HEIGHT);
        }
        return Math.PI * radius * (radius + Math.pow(height * height + radius * radius, 0.5));
    }
}
