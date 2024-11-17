package com.thealgorithms.conversions;

public final class IPConverter {
    private IPConverter() {
    }

    public static String ipToBinary(String ip) {
        StringBuilder binary = new StringBuilder();
        for (String octet : ip.split("\\.")) {
            binary.append(octetToBinary(Integer.parseInt(octet))).append(".");
        }
        return binary.substring(0, binary.length() - 1);
    }

    private static String octetToBinary(int octet) {
        char[] binary = {'0', '0', '0', '0', '0', '0', '0', '0'};
        for (int i = 7; i >= 0; i--) {
            if ((octet & 1) == 1) {
                binary[i] = '1';
            }
            octet >>>= 1;
        }
        return new String(binary);
    }

    public static String binaryToIP(String binary) {
        StringBuilder ip = new StringBuilder();
        for (String octet : binary.split("\\.")) {
            ip.append(Integer.parseInt(octet, 2)).append(".");
        }
        return ip.substring(0, ip.length() - 1);
    }
}
