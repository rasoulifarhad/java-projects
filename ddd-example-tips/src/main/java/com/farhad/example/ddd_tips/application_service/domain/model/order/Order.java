package com.farhad.example.ddd_tips.application_service.domain.model.order;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.farhad.example.ddd_tips.application_service.domain.model.client.Client;
import com.farhad.example.ddd_tips.application_service.domain.model.order.access.OrderAccessPolicy;
import com.farhad.example.ddd_tips.application_service.domain.model.order.access.ProductAccessExceptions;
import com.farhad.example.ddd_tips.application_service.domain.model.product.Product;

import io.vavr.control.Either;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
public class Order {

    @Getter
    private String orderId;

    @Getter
    private List<Product> products;

    @Getter
    private String clientId;

    @Getter
    private Status status;
    
    public static Order init(@NonNull String clientId) {
        return new Order(
            UUID.randomUUID().toString(), 
            new ArrayList<>(),
            clientId,
            Status.NEW);
    }

    public enum Status {
        NEW, PLACED, REJECTED
    }
    
    public void add(@NonNull Product product) {
        if(isOrderActive()) {
            products.add(product);
        }
    }

    public void add(@NonNull List<Product> newProducts) {
        if(isOrderActive()) {
            products.addAll(newProducts);
        }
    }
    

    public boolean isOrderActive() {
        return status.equals(Status.NEW);
    }

    public Either<ProductAccessExceptions, Order> place(Client client, OrderAccessPolicy orderAccessPolicy) {
        return orderAccessPolicy.check(this, client)
                .map(this::orderSuccessfullyPlaced);
    }

    public void reject() {
        if(isOrderActive()) {
            status = Status.REJECTED;
        }
    }

    public String getId() {
        return orderId;
    }


    private Order orderSuccessfullyPlaced(Boolean result) {
        status = Status.PLACED;
        return this;
    }

    public String renderReport() {
        return String.format(
            "Order report:%n %s",
             products.stream()
                    .map(Product::render)
                    .collect(joining("\n")));
    }
    
}
