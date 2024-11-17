package com.thealgorithms.ciphers;

import java.math.BigInteger;

public final class DiffieHellman {

    private final BigInteger base;
    private final BigInteger secret;
    private final BigInteger prime;

    public DiffieHellman(BigInteger base, BigInteger secret, BigInteger prime) {
        
        if (base == null || secret == null || prime == null || base.signum() <= 0 || secret.signum() <= 0 || prime.signum() <= 0) {
            throw new IllegalArgumentException("Base, secret, and prime must be non-null and positive values.");
        }
        this.base = base;
        this.secret = secret;
        this.prime = prime;
    }

    public BigInteger calculatePublicValue() {
        
        return base.modPow(secret, prime);
    }

    public BigInteger calculateSharedSecret(BigInteger otherPublicValue) {
        if (otherPublicValue == null || otherPublicValue.signum() <= 0) {
            throw new IllegalArgumentException("Other public value must be non-null and positive.");
        }
        
        return otherPublicValue.modPow(secret, prime);
    }
}
