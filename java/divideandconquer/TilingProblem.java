package com.thealgorithms.divideandconquer;

public final class TilingProblem {
    private TilingProblem() {
    }

    private static int tile = 1;

    private static int[][] board;

    public static int[][] solveTiling(int size, int missingRow, int missingCol) {
        board = new int[size][size];
        fillBoard(size, 0, 0, missingRow, missingCol);
        return board;
    }

    private static void fillBoard(int size, int row, int col, int missingRow, int missingCol) {
        if (size == 1) {
            return;
        }

        int half = size / 2;
        int t = tile++;

        if (missingRow < row + half && missingCol < col + half) {
            fillBoard(half, row, col, missingRow, missingCol);
        } else {
            board[row + half - 1][col + half - 1] = t;
            fillBoard(half, row, col, row + half - 1, col + half - 1);
        }

        if (missingRow < row + half && missingCol >= col + half) {
            fillBoard(half, row, col + half, missingRow, missingCol);
        } else {
            board[row + half - 1][col + half] = t;
            fillBoard(half, row, col + half, row + half - 1, col + half);
        }

        if (missingRow >= row + half && missingCol < col + half) {
            fillBoard(half, row + half, col, missingRow, missingCol);
        } else {
            board[row + half][col + half - 1] = t;
            fillBoard(half, row + half, col, row + half, col + half - 1);
        }

        if (missingRow >= row + half && missingCol >= col + half) {
            fillBoard(half, row + half, col + half, missingRow, missingCol);
        } else {
            board[row + half][col + half] = t;
            fillBoard(half, row + half, col + half, row + half, col + half);
        }
    }
}
