package com.thealgorithms.bitmanipulation;

import java.util.List;

public final class BooleanAlgebraGates {

    private BooleanAlgebraGates() {
        
    }

    interface BooleanGate {
        
        boolean evaluate(List<Boolean> inputs);
    }

    static class ANDGate implements BooleanGate {
        @Override
        public boolean evaluate(List<Boolean> inputs) {
            for (boolean input : inputs) {
                if (!input) {
                    return false;
                }
            }
            return true;
        }
    }

    static class ORGate implements BooleanGate {
        @Override
        public boolean evaluate(List<Boolean> inputs) {
            for (boolean input : inputs) {
                if (input) {
                    return true;
                }
            }
            return false;
        }
    }

    static class NOTGate {
        
        public boolean evaluate(boolean input) {
            return !input;
        }
    }

    static class XORGate implements BooleanGate {
        @Override
        public boolean evaluate(List<Boolean> inputs) {
            boolean result = false;
            for (boolean input : inputs) {
                result ^= input;
            }
            return result;
        }
    }

    static class NANDGate implements BooleanGate {
        @Override
        public boolean evaluate(List<Boolean> inputs) {
            return !new ANDGate().evaluate(inputs); 
        }
    }

    static class NORGate implements BooleanGate {
        @Override
        public boolean evaluate(List<Boolean> inputs) {
            return !new ORGate().evaluate(inputs); 
        }
    }
}
