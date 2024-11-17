package com.thealgorithms.greedyalgorithms;

public final class StockProfitCalculator {
    private StockProfitCalculator() {
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(price - minPrice, maxProfit);
        }
        return maxProfit;
    }
}
