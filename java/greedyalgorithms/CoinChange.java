package com.thealgorithms.greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public final class CoinChange {
    private CoinChange() {
    }
    
    public static ArrayList<Integer> coinChangeProblem(int amount) {
        
        Integer[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        Arrays.sort(coins, Comparator.reverseOrder());

        ArrayList<Integer> ans = new ArrayList<>(); 

        for (int i = 0; i < coins.length; i++) {
            
            if (coins[i] <= amount) {
                
                while (coins[i] <= amount) {
                    ans.add(coins[i]); 
                    amount -= coins[i]; 
                }
            }
        }
        return ans;
    }
}
