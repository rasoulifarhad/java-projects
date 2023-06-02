package com.farhad.example.decimals;

import java.math.BigDecimal;
import java.text.NumberFormat;

public enum Format {
    
    DEFAULT {

        @Override
        public String formatFloat(float floatValue) {
            return String.valueOf(floatValue);
        }

        @Override
        public String formatDouble(double doubleValue) {
            return String.valueOf(doubleValue);
        }

        @Override
        public String formatBigDecimal(BigDecimal bigDecimalValue) {
            return bigDecimalValue.toString();
        }

    },
    NO_EXPONENT {

        @Override
        public String formatFloat(float floatValue) {
            return numberFormat.format(floatValue);
        }

        @Override
        public String formatDouble(double doubleValue) {
            return numberFormat.format(doubleValue);
        }

        @Override
        public String formatBigDecimal(BigDecimal bigDecimalValue) {
            return bigDecimalValue.toPlainString();
        }

    };

    private static final NumberFormat numberFormat = NumberFormat.getInstance();
    static {
        numberFormat.setMaximumFractionDigits(Integer.MAX_VALUE);
        numberFormat.setGroupingUsed(false);
    }
     
    public abstract String formatFloat(final float floatValue);
    public abstract String formatDouble(final double doubleValue);
    public abstract String formatBigDecimal(final BigDecimal bigDecimalValue);


}
