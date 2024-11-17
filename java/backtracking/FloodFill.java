package com.thealgorithms.backtracking;

public final class FloodFill {
    private FloodFill() {
    }

    public static int getPixel(final int[][] image, final int x, final int y) {
        return image[x][y];
    }

    public static void putPixel(final int[][] image, final int x, final int y, final int newColor) {
        image[x][y] = newColor;
    }

    public static void floodFill(final int[][] image, final int x, final int y, final int newColor, final int oldColor) {
        if (newColor == oldColor || x < 0 || x >= image.length || y < 0 || y >= image[x].length || getPixel(image, x, y) != oldColor) {
            return;
        }

        putPixel(image, x, y, newColor);

        floodFill(image, x + 1, y, newColor, oldColor);
        floodFill(image, x - 1, y, newColor, oldColor);
        floodFill(image, x, y + 1, newColor, oldColor);
        floodFill(image, x, y - 1, newColor, oldColor);

        floodFill(image, x + 1, y - 1, newColor, oldColor);
        floodFill(image, x - 1, y + 1, newColor, oldColor);
        floodFill(image, x + 1, y + 1, newColor, oldColor);
        floodFill(image, x - 1, y - 1, newColor, oldColor);
    }
}
