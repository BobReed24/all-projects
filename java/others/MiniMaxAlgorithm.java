package com.thealgorithms.others;

import java.util.Arrays;
import java.util.Random;

public class MiniMaxAlgorithm {

    private int[] scores;
    private int height;

    public MiniMaxAlgorithm() {
        scores = getRandomScores(3, 99);
        height = log2(scores.length);
    }

    public static void main(String[] args) {
        MiniMaxAlgorithm miniMaxAlgorith = new MiniMaxAlgorithm();
        boolean isMaximizer = true; 
        boolean verbose = true; 
        int bestScore;

        bestScore = miniMaxAlgorith.miniMax(0, isMaximizer, 0, verbose);

        if (verbose) {
            System.out.println();
        }

        System.out.println(Arrays.toString(miniMaxAlgorith.getScores()));
        System.out.println("The best score for " + (isMaximizer ? "Maximizer" : "Minimizer") + " is " + bestScore);
    }

    public int miniMax(int depth, boolean isMaximizer, int index, boolean verbose) {
        int bestScore;
        int score1;
        int score2;

        if (depth == height) { 
            return scores[index];
        }

        score1 = miniMax(depth + 1, !isMaximizer, index * 2, verbose);
        score2 = miniMax(depth + 1, !isMaximizer, (index * 2) + 1, verbose);

        if (isMaximizer) {
            
            bestScore = Math.max(score1, score2);
        } else {
            
            bestScore = Math.min(score1, score2);
        }

        if (verbose) {
            System.out.printf("From %02d and %02d, %s chooses %02d%n", score1, score2, (isMaximizer ? "Maximizer" : "Minimizer"), bestScore);
        }

        return bestScore;
    }

    public static int[] getRandomScores(int size, int maxScore) {
        int[] randomScores = new int[(int) Math.pow(2, size)];
        Random rand = new Random();

        for (int i = 0; i < randomScores.length; i++) {
            randomScores[i] = rand.nextInt(maxScore) + 1;
        }

        return randomScores;
    }

    private int log2(int n) {
        return (n == 1) ? 0 : log2(n / 2) + 1;
    }

    public void setScores(int[] scores) {
        if (scores.length % 1 == 0) {
            this.scores = scores;
            height = log2(this.scores.length);
        } else {
            System.out.println("The number of scores must be a power of 2.");
        }
    }

    public int[] getScores() {
        return scores;
    }

    public int getHeight() {
        return height;
    }
}
