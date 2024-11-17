package com.thealgorithms.maths;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public final class FFT {
    private FFT() {
    }

    static class Complex {

        private double real;
        private double img;

        Complex() {
            real = 0;
            img = 0;
        }

        Complex(double r, double i) {
            real = r;
            img = i;
        }

        public double getReal() {
            return real;
        }

        public double getImaginary() {
            return img;
        }

        public Complex add(Complex z) {
            Complex temp = new Complex();
            temp.real = this.real + z.real;
            temp.img = this.img + z.img;
            return temp;
        }

        public Complex subtract(Complex z) {
            Complex temp = new Complex();
            temp.real = this.real - z.real;
            temp.img = this.img - z.img;
            return temp;
        }

        public Complex multiply(Complex z) {
            Complex temp = new Complex();
            temp.real = this.real * z.real - this.img * z.img;
            temp.img = this.real * z.img + this.img * z.real;
            return temp;
        }

        public Complex multiply(double n) {
            Complex temp = new Complex();
            temp.real = this.real * n;
            temp.img = this.img * n;
            return temp;
        }

        public Complex conjugate() {
            Complex temp = new Complex();
            temp.real = this.real;
            temp.img = -this.img;
            return temp;
        }

        public double abs() {
            return Math.hypot(this.real, this.img);
        }

        public Complex divide(Complex z) {
            Complex temp = new Complex();
            double d = z.abs() * z.abs();
            d = (double) Math.round(d * 1000000000d) / 1000000000d;
            temp.real = (this.real * z.real + this.img * z.img) / (d);
            temp.img = (this.img * z.real - this.real * z.img) / (d);
            return temp;
        }

        public Complex divide(double n) {
            Complex temp = new Complex();
            temp.real = this.real / n;
            temp.img = this.img / n;
            return temp;
        }

        public double real() {
            return real;
        }

        public double imaginary() {
            return img;
        }
    }

    public static ArrayList<Complex> fft(ArrayList<Complex> x, boolean inverse) {
        
        paddingPowerOfTwo(x);
        int n = x.size();
        int log2n = findLog2(n);
        x = fftBitReversal(n, log2n, x);
        int direction = inverse ? -1 : 1;

        for (int len = 2; len <= n; len *= 2) {
            double angle = -2 * Math.PI / len * direction;
            Complex wlen = new Complex(Math.cos(angle), Math.sin(angle));
            for (int i = 0; i < n; i += len) {
                Complex w = new Complex(1, 0);
                for (int j = 0; j < len / 2; j++) {
                    Complex u = x.get(i + j);
                    Complex v = w.multiply(x.get(i + j + len / 2));
                    x.set(i + j, u.add(v));
                    x.set(i + j + len / 2, u.subtract(v));
                    w = w.multiply(wlen);
                }
            }
        }
        x = inverseFFT(n, inverse, x);
        return x;
    }

    public static int findLog2(int n) {
        int log2n = 0;
        while ((1 << log2n) < n) {
            log2n++;
        }
        return log2n;
    }

    public static ArrayList<Complex> fftBitReversal(int n, int log2n, ArrayList<Complex> x) {
        int reverse;
        for (int i = 0; i < n; i++) {
            reverse = reverseBits(i, log2n);
            if (i < reverse) {
                Collections.swap(x, i, reverse);
            }
        }
        return x;
    }

    public static ArrayList<Complex> inverseFFT(int n, boolean inverse, ArrayList<Complex> x) {
        if (inverse) {
            for (int i = 0; i < x.size(); i++) {
                Complex z = x.get(i);
                x.set(i, z.divide(n));
            }
        }
        return x;
    }

    private static int reverseBits(int num, int log2n) {
        int reversed = 0;
        for (int i = 0; i < log2n; i++) {
            if ((num & (1 << i)) != 0) {
                reversed |= 1 << (log2n - 1 - i);
            }
        }
        return reversed;
    }

    private static void paddingPowerOfTwo(Collection<Complex> x) {
        int n = 1;
        int oldSize = x.size();
        while (n < oldSize) {
            n *= 2;
        }
        for (int i = 0; i < n - oldSize; i++) {
            x.add(new Complex());
        }
    }
}
