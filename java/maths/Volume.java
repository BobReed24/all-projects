package com.thealgorithms.maths;

public final class Volume {
    private Volume() {
    }

    public static double volumeCube(double sideLength) {
        return sideLength * sideLength * sideLength;
    }

    public static double volumeCuboid(double width, double height, double length) {
        return width * height * length;
    }

    public static double volumeSphere(double radius) {
        return (4 * Math.PI * radius * radius * radius) / 3;
    }

    public static double volumeCylinder(double radius, double height) {
        return Math.PI * radius * radius * height;
    }

    public static double volumeHemisphere(double radius) {
        return (2 * Math.PI * radius * radius * radius) / 3;
    }

    public static double volumeCone(double radius, double height) {
        return (Math.PI * radius * radius * height) / 3;
    }

    public static double volumePrism(double baseArea, double height) {
        return baseArea * height;
    }

    public static double volumePyramid(double baseArea, double height) {
        return (baseArea * height) / 3;
    }

    public static double volumeFrustumOfCone(double r1, double r2, double height) {
        return (Math.PI * height / 3) * (r1 * r1 + r2 * r2 + r1 * r2);
    }
}
