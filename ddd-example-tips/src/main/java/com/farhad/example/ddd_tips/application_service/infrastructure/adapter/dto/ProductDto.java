package com.farhad.example.ddd_tips.application_service.infrastructure.adapter.dto;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.farhad.example.ddd_tips.application_service.domain.model.product.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class ProductDto {
    @NonNull
    private String productId;
    private int amount;

    public static List<ProductDto> of(@NonNull List<Product> products) {
        return products.stream().map(ProductDto::of).collect(toList());
     }
  
     public static ProductDto of(@NonNull Product product) {
        return new ProductDto(product.getProductId(), product.getAmount());
     }
  
     public static List<Product> convert(List<ProductDto> products) {
        return products.stream().map(productDto -> new Product(productDto.getProductId(), productDto.getAmount())).collect(toList());
     }    
}
