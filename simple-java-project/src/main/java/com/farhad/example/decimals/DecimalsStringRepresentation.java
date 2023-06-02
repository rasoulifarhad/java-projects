package com.farhad.example.decimals;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecimalsStringRepresentation {
    
    public static void main(String[] args) {
        writeFormatedValues(Format.DEFAULT);
        writeFormatedValues(Format.NO_EXPONENT);
    }

    private  static void writeFloatsToOutput(final float start , 
                                            final float threshold,
                                            final float delta,
                                            final String label,
                                            final Format format ) {
        log.info("{}", generateHeader(label));
        float floatValue = start;
        do {
            log.info("= {}", format.formatFloat(floatValue));
            floatValue += delta;
        } while(floatValue < threshold);
    }

    private  static void writeDoublesToOutput(final double start , 
                                            final double threshold,
                                            final double delta,
                                            final String label,
                                            final Format format ) {
        log.info("{}", generateHeader(label));
        double doubleValue = start;
        do {
            log.info("= {}", format.formatDouble(doubleValue));
            doubleValue += delta;
        } while(doubleValue < threshold);
    }

    private  static void writeBigDecimalsToOutput(final BigDecimal start , 
                                            final BigDecimal threshold,
                                            final BigDecimal delta,
                                            final String label,
                                            final Format format ) {
        log.info("{}", generateHeader(label));
        BigDecimal decimal = start;
        do {
            log.info("= {}", format.formatBigDecimal(decimal));
            decimal.add(delta);
        } while(decimal.compareTo(threshold) < 0);
    }

    private static String generateHeader(String label) {
        return String.format("\n============================\n= %s =\n============================\n", label);
    }

    private static void writeFormatedValues(Format format) {

        writeFloatsToOutput(0.00085f, 0.002f, 0.0001f, String.format("Small Floats(%s)", format), format);
        writeDoublesToOutput(0.00085d, 0.002d, 0.0001d, String.format("Small Doubles(%s)", format), format);
        writeBigDecimalsToOutput(new BigDecimal("0.00000085"), 
                                new BigDecimal("0.000002"), 
                                new BigDecimal("0.0000001"), 
                                String.format("Small BigDecimals(%s)", format), format);

        writeFloatsToOutput(9_999_995f, 10_000_005f, 1f, String.format("Large Floats(%s)", format), format);
        writeDoublesToOutput(9_999_995d, 10_000_005d, 1d, String.format("Large Doubles(%s)", format), format);
        writeBigDecimalsToOutput(new BigDecimal("99999950000000000000000000000000000000000000000000"), 
                                new BigDecimal("100000050000000000000000000000000000000000000000000"), 
                                new BigDecimal("10000000000000000000000000000000000000000000"), 
                                String.format("Large BigDecimals(%s)", format), format);

    }

    static void writeFormatedSmallFloatesValues(Format format) {
        writeFloatsToOutput(0.00085f, 0.002f, 0.0001f, String.format("Small Floats(%s)", format), format);
    }

    static void writeFormatedLargeFloatesValues(Format format) {
        writeFloatsToOutput(9_999_995f, 10_000_005f, 1f, String.format("Large Floats(%s)", format), format);
    }

    static void writeFormatedSmallDoublesValues(Format format) {
        writeDoublesToOutput(0.00085d, 0.002d, 0.0001d, String.format("Small Doubles(%s)", format), format);
    }

    static void writeFormatedLargeDoublesValues(Format format) {
        writeDoublesToOutput(9_999_995d, 10_000_005d, 1d, String.format("Large Doubles(%s)", format), format);
    }

    static void writeFormatedSmallBigDecimalsValues(Format format) {
        writeBigDecimalsToOutput(new BigDecimal("0.00000085"), 
                                new BigDecimal("0.000002"), 
                                new BigDecimal("0.0000001"), 
                                String.format("Small BigDecimals(%s)", format), format);
    }

    static void writeFormatedLargeBigDecimalsValues(Format format) {
        writeBigDecimalsToOutput(new BigDecimal("99999950000000000000000000000000000000000000000000"), 
                                new BigDecimal("100000050000000000000000000000000000000000000000000"), 
                                new BigDecimal("10000000000000000000000000000000000000000000"), 
                                String.format("Large BigDecimals(%s)", format), format);
    }


}
