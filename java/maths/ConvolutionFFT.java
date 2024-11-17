package com.thealgorithms.maths;

import java.util.ArrayList;
import java.util.Collection;

public final class ConvolutionFFT {
    private ConvolutionFFT() {
    }

    private static void padding(Collection<FFT.Complex> x, int newSize) {
        if (x.size() < newSize) {
            int diff = newSize - x.size();
            for (int i = 0; i < diff; i++) {
                x.add(new FFT.Complex());
            }
        }
    }

    public static ArrayList<FFT.Complex> convolutionFFT(ArrayList<FFT.Complex> a, ArrayList<FFT.Complex> b) {
        int convolvedSize = a.size() + b.size() - 1; 
        padding(a, convolvedSize); 
        padding(b, convolvedSize);

        FFT.fft(a, false);
        FFT.fft(b, false);
        ArrayList<FFT.Complex> convolved = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            convolved.add(a.get(i).multiply(b.get(i))); 
        }
        FFT.fft(convolved, true); 
        convolved.subList(convolvedSize, convolved.size()).clear(); 
                                                                    
        return convolved;
    }
}
