package com.farhad.example.dispatch.singledispatch;

import org.junit.jupiter.api.Test;

import com.farhad.example.dispatch.singledispatch.AmountBasedDiscountPolicy;
import com.farhad.example.dispatch.singledispatch.DiscountPolicy;
import com.farhad.example.dispatch.singledispatch.FixedDiscountPolicy;
import com.farhad.example.dispatch.singledispatch.GoldishDiscountPolicy;
import com.farhad.example.dispatch.singledispatch.GoldishOrder;
import com.farhad.example.dispatch.singledispatch.Order;

import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.assertThat;;

   
@Slf4j
public class DiscountTest {


    @Test
    public void single_dispatch_test() {

        // Given
        DiscountPolicy fixedPolicy = new FixedDiscountPolicy();
        DiscountPolicy amountBaseDiscountPolicy = new AmountBasedDiscountPolicy();

        Order orderWith501Dollars = Order.orderOfOneProduct501();

        // When
        double fixDiscount = fixedPolicy.discount(orderWith501Dollars);
        double amountBasedDiscount = amountBaseDiscountPolicy.discount(orderWith501Dollars);

        // Then
        log.info("fixDiscount: {}", fixDiscount);
        log.info("amountBasedDiscount: {}", amountBasedDiscount);
        assertThat(fixDiscount).isEqualTo(0.01);
        assertThat(amountBasedDiscount).isEqualTo(0.1);
    }

    @Test
    public void goldish_single_dispatch_test() {

        // Given
        GoldishDiscountPolicy discountPolicy = new GoldishDiscountPolicy() {

            @Override
            public double discount(GoldishOrder order) {
                return 0.10;
            }

            @Override
            public double discount(Order order) {
                return 0.01;
            }
        };

        Order goldishOrder = GoldishOrder.orderOfOneProduct501();

        // When
        double discount = discountPolicy.discount(goldishOrder);

        // Then
        log.info("discount: {}", discount);
        assertThat(discount).isEqualTo(0.01);

    }

}
