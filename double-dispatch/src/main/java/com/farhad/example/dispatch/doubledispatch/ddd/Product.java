package com.farhad.example.dispatch.doubledispatch.ddd;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;


@RequiredArgsConstructor(staticName = "of")
@Getter
public class Product {
    
    private final String name ;
    private final Money price;

    public static final Product PRODUCT_500 = Product.of("PRODUCT_500",
                                                        Money.of(
                                                                BigDecimal.valueOf(500.00),CurrencyUnit.USD));

    public static final Product PRODUCT_501 = Product.of("PRODUCT_501",
                                                        Money.of(
                                                                BigDecimal.valueOf(501.00),CurrencyUnit.USD));

}
