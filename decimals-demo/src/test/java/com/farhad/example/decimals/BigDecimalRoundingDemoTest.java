package com.farhad.example.decimals;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

public class BigDecimalRoundingDemoTest {

    @Test
    public void demonstrateScale() {
        BigDecimal base = new BigDecimal("35.3456");
        
        BigDecimal b1 = base.round(new MathContext(4, RoundingMode.HALF_UP));
        BigDecimal b2 = base.setScale(4, RoundingMode.HALF_UP);
        System.out.println(b1);
        System.out.println(b2);
    }

    @Test
    public void demonstrateScale_02() {
        BigDecimal base = new BigDecimal("35.34567");
        
        BigDecimal b1 = base.round(new MathContext(4, RoundingMode.HALF_UP));
        BigDecimal b2 = base.setScale(4, RoundingMode.HALF_UP);
        System.out.println(b1);
        System.out.println(b2);
    }

}
