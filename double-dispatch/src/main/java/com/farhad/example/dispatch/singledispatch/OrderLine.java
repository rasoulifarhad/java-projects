package com.farhad.example.dispatch.singledispatch;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class OrderLine {

    private final Product product;
    private final int quantity;

    public static List<OrderLine> oneProduct501(){

        return oneProduct(Product.PRODUCT_501);
    }

    public static List<OrderLine> oneProduct500(){

        return oneProduct(Product.PRODUCT_500);
    }
    
    public static List<OrderLine> oneProduct(Product product ){

        return oneProduct(product,1);
    }

    public static List<OrderLine> oneProduct(Product product , int quantity){

        return 
                Arrays.asList(
                            OrderLine.of(
                                        product, 
                                        quantity));

    }

}
