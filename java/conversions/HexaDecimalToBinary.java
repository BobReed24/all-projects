package com.thealgorithms.conversions;

public class HexaDecimalToBinary {

    public String convert(String numHex) {
        int conHex = Integer.parseInt(numHex, 16);
        String binary = Integer.toBinaryString(conHex);
        return completeDigits(binary);
    }

    public String completeDigits(String binNum) {
        final int byteSize = 8;
        StringBuilder binNumBuilder = new StringBuilder(binNum);
        while (binNumBuilder.length() < byteSize) {
            binNumBuilder.insert(0, "0");
        }
        binNum = binNumBuilder.toString();
        return binNum;
    }
}
