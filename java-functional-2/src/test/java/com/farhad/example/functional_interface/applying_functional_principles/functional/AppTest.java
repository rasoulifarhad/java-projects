package com.farhad.example.functional_interface.applying_functional_principles.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testBuyDonuts() {
        CreditCard card = new CreditCard(BigDecimal.valueOf(100));
        Tuple<List<Donut>, Payment> purchase = DonutShop.buyDonut(5, card);
        assertEquals(Donut.price().multiply(BigDecimal.valueOf(5)), purchase._2().getAmount());
        assertEquals(card, purchase._2().getCreditCard());

    }

}
