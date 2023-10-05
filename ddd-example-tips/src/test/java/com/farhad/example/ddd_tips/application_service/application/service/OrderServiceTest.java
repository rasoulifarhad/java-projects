package com.farhad.example.ddd_tips.application_service.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.farhad.example.ddd_tips.application_service.Application;
import com.farhad.example.ddd_tips.application_service.domain.model.client.ClientAccessException;
import com.farhad.example.ddd_tips.application_service.domain.model.order.Order;
import com.farhad.example.ddd_tips.application_service.domain.model.product.Product;

@SpringBootTest( classes = Application.class)
@ActiveProfiles({ "domain-test", "mock-order-repository", "mock-client-service" })
public class OrderServiceTest {
  
   @Autowired
   private OrderService orderService;
   private final String UUID_PATTERN = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$";

   @Test
   void shouldSuccessfullyPlaceOrder() {
      //   given
      String clientId = "john_doe";
      String productId = "basic";
      int amount = 10;
      Product product = new Product(productId, amount);

      //      when
      Order order = orderService.placeOrder(Arrays.asList(product), clientId);

      //      then
      assertThat(order).isNotNull();
      assertThat(order.getId()).isNotBlank();
      //Assert that the string is a valid UUID
      assertThat(order.getId()).matches(UUID_PATTERN);
      assertThat(order.getStatus()).isEqualTo(Order.Status.PLACED);
   }

   @Test
   void shouldThrowExceptionForOrderPlacementWhenClientNotExists() {
      //   given
      String clientId = "none";
      String productId = "premium_1";
      int amount = 10;
      List<Product> products = Arrays.asList(new Product(productId, amount));

      //      when
      assertThrows(ClientAccessException.class, () -> orderService.placeOrder(products, clientId));
   }

   @Test
   void shouldRejectOrderWhenProductNotAccessible() {
      //   given
      String clientId = "john_doe";
      String productId = "premium_1";
      int amount = 10;
      Product product = new Product(productId, amount);

      //      when
      Order order = orderService.placeOrder(Arrays.asList(product), clientId);

      //      then
      assertThat(order).isNotNull();
      assertThat(order.getId()).isNotBlank();
      assertThat(order.getStatus()).isEqualTo(Order.Status.REJECTED);
   }    
}
