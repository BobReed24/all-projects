package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thealgorithms.bitmanipulation.BooleanAlgebraGates.ANDGate;
import com.thealgorithms.bitmanipulation.BooleanAlgebraGates.BooleanGate;
import com.thealgorithms.bitmanipulation.BooleanAlgebraGates.NANDGate;
import com.thealgorithms.bitmanipulation.BooleanAlgebraGates.NORGate;
import com.thealgorithms.bitmanipulation.BooleanAlgebraGates.NOTGate;
import com.thealgorithms.bitmanipulation.BooleanAlgebraGates.ORGate;
import com.thealgorithms.bitmanipulation.BooleanAlgebraGates.XORGate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class BooleanAlgebraGatesTest {

    @ParameterizedTest(name = "ANDGate Test Case {index}: inputs={0} -> expected={1}")
    @MethodSource("provideAndGateTestCases")
    void testANDGate(List<Boolean> inputs, boolean expected) {
        BooleanGate gate = new ANDGate();
        assertEquals(expected, gate.evaluate(inputs));
    }

    @ParameterizedTest(name = "ORGate Test Case {index}: inputs={0} -> expected={1}")
    @MethodSource("provideOrGateTestCases")
    void testORGate(List<Boolean> inputs, boolean expected) {
        BooleanGate gate = new ORGate();
        assertEquals(expected, gate.evaluate(inputs));
    }

    @ParameterizedTest(name = "NOTGate Test Case {index}: input={0} -> expected={1}")
    @CsvSource({"true, false", "false, true"})
    void testNOTGate(boolean input, boolean expected) {
        NOTGate gate = new NOTGate();
        assertEquals(expected, gate.evaluate(input));
    }

    @ParameterizedTest(name = "XORGate Test Case {index}: inputs={0} -> expected={1}")
    @MethodSource("provideXorGateTestCases")
    void testXORGate(List<Boolean> inputs, boolean expected) {
        BooleanGate gate = new XORGate();
        assertEquals(expected, gate.evaluate(inputs));
    }

    @ParameterizedTest(name = "NANDGate Test Case {index}: inputs={0} -> expected={1}")
    @MethodSource("provideNandGateTestCases")
    void testNANDGate(List<Boolean> inputs, boolean expected) {
        BooleanGate gate = new NANDGate();
        assertEquals(expected, gate.evaluate(inputs));
    }

    @ParameterizedTest(name = "NORGate Test Case {index}: inputs={0} -> expected={1}")
    @MethodSource("provideNorGateTestCases")
    void testNORGate(List<Boolean> inputs, boolean expected) {
        BooleanGate gate = new NORGate();
        assertEquals(expected, gate.evaluate(inputs));
    }

    static Stream<Object[]> provideAndGateTestCases() {
        return Stream.of(new Object[] {Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE), Boolean.TRUE}, new Object[] {Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE), Boolean.FALSE}, new Object[] {Arrays.asList(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE), Boolean.FALSE},
            new Object[] {Collections.emptyList(), Boolean.TRUE} 
        );
    }

    static Stream<Object[]> provideOrGateTestCases() {
        return Stream.of(new Object[] {Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), Boolean.TRUE}, new Object[] {Arrays.asList(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE), Boolean.FALSE}, new Object[] {Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE), Boolean.TRUE},
            new Object[] {Collections.emptyList(), Boolean.FALSE} 
        );
    }

    static Stream<Object[]> provideXorGateTestCases() {
        return Stream.of(new Object[] {Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE), Boolean.FALSE}, 
            new Object[] {Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), Boolean.TRUE}, 
            new Object[] {Arrays.asList(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE), Boolean.FALSE}, 
            new Object[] {Arrays.asList(Boolean.TRUE, Boolean.TRUE), Boolean.FALSE} 
        );
    }

    static Stream<Object[]> provideNandGateTestCases() {
        return Stream.of(new Object[] {Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE), Boolean.FALSE}, 
            new Object[] {Arrays.asList(Boolean.TRUE, Boolean.FALSE), Boolean.TRUE}, 
            new Object[] {Arrays.asList(Boolean.FALSE, Boolean.FALSE), Boolean.TRUE}, 
            new Object[] {Collections.emptyList(), Boolean.FALSE} 
        );
    }

    static Stream<Object[]> provideNorGateTestCases() {
        return Stream.of(new Object[] {Arrays.asList(Boolean.FALSE, Boolean.FALSE), Boolean.TRUE}, 
            new Object[] {Arrays.asList(Boolean.FALSE, Boolean.TRUE), Boolean.FALSE}, 
            new Object[] {Arrays.asList(Boolean.TRUE, Boolean.TRUE), Boolean.FALSE}, 
            new Object[] {Collections.emptyList(), Boolean.TRUE} 
        );
    }
}
