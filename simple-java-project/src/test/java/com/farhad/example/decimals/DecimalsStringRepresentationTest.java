package com.farhad.example.decimals;

import static com.farhad.example.decimals.DecimalsStringRepresentation.writeFormatedLargeBigDecimalsValues;
import static com.farhad.example.decimals.DecimalsStringRepresentation.writeFormatedLargeDoublesValues;
import static com.farhad.example.decimals.DecimalsStringRepresentation.writeFormatedLargeFloatesValues;
import static com.farhad.example.decimals.DecimalsStringRepresentation.writeFormatedSmallBigDecimalsValues;
import static com.farhad.example.decimals.DecimalsStringRepresentation.writeFormatedSmallDoublesValues;
import static com.farhad.example.decimals.DecimalsStringRepresentation.writeFormatedSmallFloatesValues;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecimalsStringRepresentationTest {
    

    @Test
    public void writeFormatedSmallFloatesValuesTest() {
        writeFormatedSmallFloatesValues(Format.DEFAULT);
        writeFormatedSmallFloatesValues(Format.NO_EXPONENT);
    }

    @Test
    public void writeFormatedLargeFloatesValuesTest() {
        writeFormatedLargeFloatesValues(Format.DEFAULT);
        writeFormatedLargeFloatesValues(Format.NO_EXPONENT);
    }

    @Test
    public void writeFormatedSmallDoublesValuesTest() {
        writeFormatedSmallDoublesValues(Format.DEFAULT);
        writeFormatedSmallDoublesValues(Format.NO_EXPONENT);
    }

    @Test
    public void writeFormatedLargeDoublesValuesTest() {
        writeFormatedLargeDoublesValues(Format.DEFAULT);
        writeFormatedLargeDoublesValues(Format.NO_EXPONENT);
    }

    @Test
    public void writeFormatedSmallBigDecimalsValuesTest() {
        writeFormatedSmallBigDecimalsValues(Format.DEFAULT);
        writeFormatedSmallBigDecimalsValues(Format.NO_EXPONENT);
    }

    @Test
    public void writeFormatedLargeBigDecimalsValuesTest() {
        writeFormatedLargeBigDecimalsValues(Format.DEFAULT);
        writeFormatedLargeBigDecimalsValues(Format.NO_EXPONENT);
    }

}
