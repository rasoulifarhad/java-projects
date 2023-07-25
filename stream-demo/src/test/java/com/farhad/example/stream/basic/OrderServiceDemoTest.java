package com.farhad.example.stream.basic;

import static com.farhad.example.stream.basic.OrderServiceDemo.Support.givenALoggedInUser;
import static com.farhad.example.stream.basic.OrderServiceDemo.Support.itemsToBuy;

import org.apache.commons.lang3.Validate;
import org.junit.jupiter.api.Test;

import com.farhad.example.stream.basic.OrderServiceDemo.Order;
import com.farhad.example.stream.basic.OrderServiceDemo.OrderService;
import com.farhad.example.stream.basic.OrderServiceDemo.User;
import com.farhad.example.stream.basic.OrderServiceDemo.UserService;

public class OrderServiceDemoTest {

    final UserService userService = new UserService();
    final OrderService orderService = new OrderService();
    @Test
    public void test_() {

        givenALoggedInUser(userService);

        itemsToBuy().stream()
                    .map(item -> new Order(item.id(), currentUser().id()) )
                    .forEach(orderService::sendOrder);
        System.out.println(String.format("Sent %d orders", orderService.sendOrders()));

    }

    User currentUser() {
        final User user = userService.currentUser();
        Validate.validState(user != null, "No current user found");
        return user;
    }
}
