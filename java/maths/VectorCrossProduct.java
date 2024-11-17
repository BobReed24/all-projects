package com.thealgorithms.maths;

public class VectorCrossProduct {

    int x;
    int y;
    int z;

    VectorCrossProduct() {
        x = 0;
        y = 0;
        z = 0;
    }

    VectorCrossProduct(int vectorX, int vectorY, int vectorZ) {
        x = vectorX;
        y = vectorY;
        z = vectorZ;
    }

    double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    int dotProduct(VectorCrossProduct b) {
        return x * b.x + y * b.y + z * b.z;
    }

    VectorCrossProduct crossProduct(VectorCrossProduct b) {
        VectorCrossProduct product = new VectorCrossProduct();
        product.x = (y * b.z) - (z * b.y);
        product.y = -((x * b.z) - (z * b.x));
        product.z = (x * b.y) - (y * b.x);
        return product;
    }

    void displayVector() {
        System.out.println("x : " + x + "\ty : " + y + "\tz : " + z);
    }

    public static void main(String[] args) {
        test();
    }

    static void test() {
        
        VectorCrossProduct a = new VectorCrossProduct(1, -2, 3);
        VectorCrossProduct b = new VectorCrossProduct(2, 0, 3);

        VectorCrossProduct crossProd = a.crossProduct(b);
        crossProd.displayVector();

        int dotProd = a.dotProduct(b);
        System.out.println("Dot Product of a and b: " + dotProd);
    }
}
