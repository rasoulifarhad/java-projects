package com.farhad.example.working_legacy_code.statistical_moment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class InstrumentCalculatorTest {

    @Test
    public void testFirstMoment() {
        InstrumentCalculator calculator = new InstrumentCalculator();
        calculator.addElement(1.0);
        calculator.addElement(2.0);
        assertEquals(-0.5, calculator.firstMomentAbout(2.0));
    }

    @Test
    public void testFirstMomentWithNoPointAdded() {
        assertThrows(InvalidBasicException.class, () -> {
            InstrumentCalculator calculator = new InstrumentCalculator();
            calculator.firstMomentAbout(0.0);
        });
    }

}
