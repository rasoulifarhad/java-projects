package com.farhad.example.functional_interface.applying_functional_principles.functional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DonutShop {
    
    public static Tuple<Donut, Payment> buyDonut(CreditCard creditCard) {    
        Donut donut = new Donut();
        Payment payment = new Payment(creditCard, Donut.price());
        return new Tuple<Donut,Payment>(donut, payment);
    }

    public static Tuple<List<Donut>, Payment> buyDonut(final int quantity, final CreditCard creditCard) {    
        return new Tuple<List<Donut>,Payment>(
            fill(quantity, () -> new Donut()), 
            new Payment(creditCard, Donut.price().multiply(BigDecimal.valueOf(quantity))));
    }

    private static List<Donut> fill(int quantity, Supplier<Donut> supplier) {
        return IntStream.range(0, quantity)
                    .mapToObj(value -> supplier.get())
                    .collect(Collectors.toList());
    }

    private static List<Donut> fill2(int quantity, Supplier<Donut> supplier) {
        return Collections.nCopies(quantity, new Donut());
    }

}
