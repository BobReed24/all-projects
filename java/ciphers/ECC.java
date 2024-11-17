package com.thealgorithms.ciphers;

import java.math.BigInteger;
import java.security.SecureRandom;

public class ECC {

    private BigInteger privateKey; 
    private ECPoint publicKey; 
    private EllipticCurve curve; 
    private ECPoint basePoint; 

    public ECC(int bits) {
        generateKeys(bits); 
    }

    public EllipticCurve getCurve() {
        return curve; 
    }

    public void setCurve(EllipticCurve curve) {
        this.curve = curve;
    }

    public BigInteger getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(BigInteger privateKey) {
        this.privateKey = privateKey;
    }

    public ECPoint[] encrypt(String message) {
        BigInteger m = new BigInteger(message.getBytes()); 
        SecureRandom r = new SecureRandom(); 
        BigInteger k = new BigInteger(curve.getFieldSize(), r); 

        ECPoint rPoint = basePoint.multiply(k, curve.getP(), curve.getA());

        ECPoint sPoint = publicKey.multiply(k, curve.getP(), curve.getA()).add(curve.encodeMessage(m), curve.getP(), curve.getA());

        return new ECPoint[] {rPoint, sPoint}; 
    }

    public String decrypt(ECPoint[] encryptedMessage) {
        ECPoint rPoint = encryptedMessage[0]; 
        ECPoint sPoint = encryptedMessage[1]; 

        ECPoint decodedMessage = sPoint.subtract(rPoint.multiply(privateKey, curve.getP(), curve.getA()), curve.getP(), curve.getA());

        BigInteger m = curve.decodeMessage(decodedMessage); 

        return new String(m.toByteArray()); 
    }

    public final void generateKeys(int bits) {
        SecureRandom r = new SecureRandom();
        curve = new EllipticCurve(bits); 
        basePoint = curve.getBasePoint(); 

        privateKey = new BigInteger(bits, r);

        publicKey = basePoint.multiply(privateKey, curve.getP(), curve.getA());
    }

    public static class EllipticCurve {
        private final BigInteger a; 
        private final BigInteger b; 
        private final BigInteger p; 
        private final ECPoint basePoint; 

        public EllipticCurve(BigInteger a, BigInteger b, BigInteger p, ECPoint basePoint) {
            this.a = a;
            this.b = b;
            this.p = p;
            this.basePoint = basePoint;
        }

        public EllipticCurve(int bits) {
            SecureRandom r = new SecureRandom();
            this.p = BigInteger.probablePrime(bits, r); 
            this.a = new BigInteger(bits, r); 
            this.b = new BigInteger(bits, r); 
            this.basePoint = new ECPoint(BigInteger.valueOf(4), BigInteger.valueOf(8)); 
        }

        public ECPoint getBasePoint() {
            return basePoint;
        }

        public BigInteger getP() {
            return p;
        }

        public BigInteger getA() {
            return a;
        }

        public BigInteger getB() {
            return b;
        }

        public int getFieldSize() {
            return p.bitLength();
        }

        public ECPoint encodeMessage(BigInteger message) {
            
            return new ECPoint(message, message);
        }

        public BigInteger decodeMessage(ECPoint point) {
            return point.getX(); 
        }
    }

    public static class ECPoint {
        private final BigInteger x; 
        private final BigInteger y; 

        public ECPoint(BigInteger x, BigInteger y) {
            this.x = x;
            this.y = y;
        }

        public BigInteger getX() {
            return x;
        }

        public BigInteger getY() {
            return y;
        }

        @Override
        public String toString() {
            return "ECPoint(x=" + x.toString() + ", y=" + y.toString() + ")";
        }

        public ECPoint add(ECPoint other, BigInteger p, BigInteger a) {
            if (this.x.equals(BigInteger.ZERO) && this.y.equals(BigInteger.ZERO)) {
                return other; 
            }
            if (other.x.equals(BigInteger.ZERO) && other.y.equals(BigInteger.ZERO)) {
                return this; 
            }

            BigInteger lambda;
            if (this.equals(other)) {
                
                lambda = this.x.pow(2).multiply(BigInteger.valueOf(3)).add(a).multiply(this.y.multiply(BigInteger.valueOf(2)).modInverse(p)).mod(p);
            } else {
                
                lambda = other.y.subtract(this.y).multiply(other.x.subtract(this.x).modInverse(p)).mod(p);
            }

            BigInteger xr = lambda.pow(2).subtract(this.x).subtract(other.x).mod(p);
            BigInteger yr = lambda.multiply(this.x.subtract(xr)).subtract(this.y).mod(p);

            return new ECPoint(xr, yr);
        }

        public ECPoint subtract(ECPoint other, BigInteger p, BigInteger a) {
            ECPoint negOther = new ECPoint(other.x, p.subtract(other.y)); 
            return this.add(negOther, p, a); 
        }

        public ECPoint multiply(BigInteger k, BigInteger p, BigInteger a) {
            ECPoint result = new ECPoint(BigInteger.ZERO, BigInteger.ZERO); 
            ECPoint addend = this;

            while (k.signum() > 0) {
                if (k.testBit(0)) {
                    result = result.add(addend, p, a); 
                }
                addend = addend.add(addend, p, a); 
                k = k.shiftRight(1); 
            }

            return result;
        }
    }
}
