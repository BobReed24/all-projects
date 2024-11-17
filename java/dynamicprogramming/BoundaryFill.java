package com.thealgorithms.dynamicprogramming;

public final class BoundaryFill {
    private BoundaryFill() {
    }

    public static int getPixel(int[][] image, int xCoordinate, int yCoordinate) {
        return image[xCoordinate][yCoordinate];
    }

    public static void putPixel(int[][] image, int xCoordinate, int yCoordinate, int newColor) {
        image[xCoordinate][yCoordinate] = newColor;
    }

    public static void boundaryFill(int[][] image, int xCoordinate, int yCoordinate, int newColor, int boundaryColor) {
        if (xCoordinate >= 0 && yCoordinate >= 0 && getPixel(image, xCoordinate, yCoordinate) != newColor && getPixel(image, xCoordinate, yCoordinate) != boundaryColor) {
            putPixel(image, xCoordinate, yCoordinate, newColor);
            boundaryFill(image, xCoordinate + 1, yCoordinate, newColor, boundaryColor);
            boundaryFill(image, xCoordinate - 1, yCoordinate, newColor, boundaryColor);
            boundaryFill(image, xCoordinate, yCoordinate + 1, newColor, boundaryColor);
            boundaryFill(image, xCoordinate, yCoordinate - 1, newColor, boundaryColor);
            boundaryFill(image, xCoordinate + 1, yCoordinate - 1, newColor, boundaryColor);
            boundaryFill(image, xCoordinate - 1, yCoordinate + 1, newColor, boundaryColor);
            boundaryFill(image, xCoordinate + 1, yCoordinate + 1, newColor, boundaryColor);
            boundaryFill(image, xCoordinate - 1, yCoordinate - 1, newColor, boundaryColor);
        }
    }
}
