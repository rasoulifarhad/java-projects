package com.farhad.example.dispatch.doubledispatch.ddd;

import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;;

@Slf4j
public class DiscountTest {
    

    @Test
    public void dispatch_test() {

        // Given
        Order orderWith500Dollars = Order.orderOfOneProduct500();

        GoldishDiscountPolicy discountPolicy = new GoldishDiscountPolicy() {

            @Override
            public double discount(GoldishOrder order) {
                return 0;
            }

            @Override
            public double discount(Order order) {
                return 0.10;
            }
        };

        // When
        Money totalCostAfterDiscount = orderWith500Dollars.totalCost(discountPolicy);
        // Then
        log.info("totalCostAfterDiscount: {}",totalCostAfterDiscount.getValue());
        assertThat(totalCostAfterDiscount.getValue().compareTo( BigDecimal.valueOf(450) )).isEqualTo( 0 );

    }

    @Test
    public void goldish_dispatch_test() {

        // Given
        Order orderWith500Dollars = GoldishOrder.orderOfOneProduct500();

        GoldishDiscountPolicy discountPolicy = new GoldishDiscountPolicy() {

            @Override
            public double discount(GoldishOrder order) {
                return 0.10;
            }

            @Override
            public double discount(Order order) {
                return 0;
            }
        };

        // When
        Money totalCostAfterDiscount = orderWith500Dollars.totalCost(discountPolicy);
        // Then
        log.info("totalCostAfterDiscount: {}",totalCostAfterDiscount.getValue());
        assertThat(totalCostAfterDiscount.getValue().compareTo( BigDecimal.valueOf(450) )).isEqualTo( 0 );

    }
}
