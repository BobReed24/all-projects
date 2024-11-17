package com.thealgorithms.datastructures.queues;

import java.util.concurrent.TimeUnit;

public final class TokenBucket {
    private final int maxTokens;
    private final int refillRate; 
    private int tokens;
    private long lastRefill; 

    public TokenBucket(int maxTokens, int refillRate) {
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        this.tokens = maxTokens;
        this.lastRefill = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        refillTokens();
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refillTokens() {
        long now = System.nanoTime();
        long tokensToAdd = (now - lastRefill) / TimeUnit.SECONDS.toNanos(1) * refillRate;
        tokens = Math.min(maxTokens, tokens + (int) tokensToAdd);
        lastRefill = now;
    }
}
