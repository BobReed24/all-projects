package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

public class ECCTest {
    ECC ecc = new ECC(256); 

    @Test
    void testEncrypt() {
        String textToEncrypt = "Elliptic Curve Cryptography";

        ECC.ECPoint[] cipherText = ecc.encrypt(textToEncrypt); 

        System.out.println("Private Key: " + ecc.getPrivateKey());

        ECC.EllipticCurve curve = ecc.getCurve();
        System.out.println("Elliptic Curve Parameters:");
        System.out.println("a: " + curve.getA());
        System.out.println("b: " + curve.getB());
        System.out.println("p: " + curve.getP());
        System.out.println("Base Point G: " + curve.getBasePoint());

        assertEquals(cipherText.length, 2); 

        System.out.println("Encrypted Points:");
        for (ECC.ECPoint point : cipherText) {
            System.out.println(point); 
        }
    }

    @Test
    void testDecryptWithKnownValues() {
        
        BigInteger knownPrivateKey = new BigInteger("28635978664199231399690075483195602260051035216440375973817268759912070302603");

        BigInteger a = new BigInteger("64505295837372135469230827475895976532873592609649950000895066186842236488761"); 
        BigInteger b = new BigInteger("89111668838830965251111555638616364203833415376750835901427122343021749874324"); 
        BigInteger p = new BigInteger("107276428198310591598877737561885175918069075479103276920057092968372930219921"); 
        ECC.ECPoint basePoint = new ECC.ECPoint(new BigInteger("4"), new BigInteger("8")); 

        ECC.EllipticCurve curve = new ECC.EllipticCurve(a, b, p, basePoint);

        ECC.ECPoint rPoint = new ECC.ECPoint(new BigInteger("103077584019003058745849614420912636617007257617156724481937620119667345237687"), new BigInteger("68193862907937248121971710522760893811582068323088661566426323952783362061817"));
        ECC.ECPoint sPoint = new ECC.ECPoint(new BigInteger("31932232426664380635434632300383525435115368414929679432313910646436992147798"), new BigInteger("77299754382292904069123203569944908076819220797512755280123348910207308129766"));
        ECC.ECPoint[] cipherText = new ECC.ECPoint[] {rPoint, sPoint};

        ecc.setPrivateKey(knownPrivateKey); 
        ecc.setCurve(curve); 

        String decryptedMessage = ecc.decrypt(cipherText);

        String expectedMessage = "Elliptic Curve Cryptography"; 
        assertEquals(expectedMessage, decryptedMessage);
    }

    @Test
    void testCipherTextRandomness() {
        String message = "Elliptic Curve Cryptography";

        ECC.ECPoint[] cipherText1 = ecc.encrypt(message);
        ECC.ECPoint[] cipherText2 = ecc.encrypt(message);

        assertNotEquals(cipherText1, cipherText2); 
    }

    @Test
    void testECCEncryptionAndDecryption() {
        String textToEncrypt = "Elliptic Curve Cryptography";
        ECC.ECPoint[] cipherText = ecc.encrypt(textToEncrypt);
        String decryptedText = ecc.decrypt(cipherText);
        assertEquals(textToEncrypt, decryptedText); 
    }
}
