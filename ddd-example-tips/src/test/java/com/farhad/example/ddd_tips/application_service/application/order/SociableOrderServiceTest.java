package com.farhad.example.ddd_tips.application_service.application.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.farhad.example.ddd_tips.application_service.application.service.OrderService;
import com.farhad.example.ddd_tips.application_service.domain.model.client.ClientAccessException;
import com.farhad.example.ddd_tips.application_service.domain.model.order.Order;
import com.farhad.example.ddd_tips.application_service.domain.model.product.Product;

@ExtendWith(MockitoExtension.class)
public class SociableOrderServiceTest {

    static final String UUID_PATTERN = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    @Autowired
    private OrderService orderService;

    @Test
    void shouldSuccessfullyPlaceOrder() {
        // given
        String clientId = "client1";
        String productId = "basic";
        int amount = 10;
        Product product = new Product(productId, amount);

        // when
        Order order = orderService.placeOrder(Arrays.asList(product), clientId);

        // then
        assertThat(order).isNotNull();
        assertThat(order.getId()).isNotBlank();
        // Assert that the string is a valid UUID
        assertThat(order.getId()).matches(UUID_PATTERN);
        assertThat(order.getStatus()).isEqualTo(Order.Status.PLACED);
    }

    @Test
    void shouldThrowExceptionForOrderPlacementWhenClientNotExists() {
        // given
        String clientId = "none";
        String productId = "premium_1";
        int amount = 10;
        List<Product> products = Arrays.asList(new Product(productId, amount));

        // when
        assertThrows(ClientAccessException.class, () -> orderService.placeOrder(products, clientId));
    }

    @Test
    void shouldRejectOrderWhenProductNotAccessible() {
        // given
        String clientId = "client1";
        String productId = "premium_1";
        int amount = 10;
        Product product = new Product(productId, amount);

        // when
        Order order = orderService.placeOrder(Arrays.asList(product), clientId);

        // then
        assertThat(order).isNotNull();
        assertThat(order.getId()).isNotBlank();
        assertThat(order.getStatus()).isEqualTo(Order.Status.REJECTED);
    }
}