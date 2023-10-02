package com.farhad.example.functional_interface.discount;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DiscountImperative {
    public static void main(String[] args) {
        final List<BigDecimal> prices = Arrays.asList(
            new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
            new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
            new BigDecimal("45"), new BigDecimal("12"));

        BigDecimal totalOfDiscountedPricees = BigDecimal.ZERO;
        for (BigDecimal price : prices) {
            if(price.compareTo(BigDecimal.valueOf(20)) > 0) {
                totalOfDiscountedPricees =
                    totalOfDiscountedPricees.add(price.multiply(BigDecimal.valueOf(0.9)));
            }
        }
        System.out.println("Total of discounted prices: " + totalOfDiscountedPricees);

    }
}
