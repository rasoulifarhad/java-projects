package com.farhad.example.dispatch.doubledispatch.v1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class Product {
    
    private final String name ;
    private final Money price;

    public static final Product PRODUCT_500 = Product.of("PRODUCT_500",
                                                        Money.of(
                                                                500.00,CurrencyUnit.USD));

    public static final Product PRODUCT_501 = Product.of("PRODUCT_501",
                                                        Money.of(
                                                                501.00,CurrencyUnit.USD));

}
