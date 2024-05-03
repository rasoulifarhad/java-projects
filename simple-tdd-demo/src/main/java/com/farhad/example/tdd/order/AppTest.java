package com.farhad.example.tdd.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AppTest {

    public static void main(String[] args) {
        AppTest appTest = new AppTest();
        // appTest.shouldInsertNewOrderToDatabaseWhenOrderIsPlaced();
        // appTest.shouldInsertNewOrderToDatabaseWhenOrderIsPlaced_fake();
        appTest.shouldInsertNewOrderToDatabaseWhenOrderIsPlaced_configurable();
    }

    public void shouldInsertNewOrderToDatabaseWhenOrderIsPlaced()  {
        // Given
        OrderDatabase orderDatabase = new MySqlOrderDatabase();
        orderDatabase.connect();
        orderDatabase.clean();
        OrderProcessing orderProcessing = new OrderProcessing(orderDatabase, new FileLog());
        Order order = new Order("customer 1", "", "product 1", Instant.now(), 1);

        // When
        orderProcessing.place(order);
        
        // Then
        List<Order> allOrders = orderDatabase.selectAllOrders();
        assertThat(allOrders).contains(order);
    }

    public void shouldInsertNewOrderToDatabaseWhenOrderIsPlaced_fake()  {
        // Given
        OrderDatabase orderDatabase = new FakeOrderDatabase();
        orderDatabase.connect();
        orderDatabase.clean();
        OrderProcessing orderProcessing = new OrderProcessing(orderDatabase, new FileLog());
        Order order = new Order("customer 1", "", "product 1", Instant.now(), 1);

        // When
        orderProcessing.place(order);
        
        // Then
        List<Order> allOrders = orderDatabase.selectAllOrders();
        assertThat(allOrders).contains(order);
    }

    
    public void shouldInsertNewOrderToDatabaseWhenOrderIsPlaced_configurable()  {
        // Given
        ConfigurableOrderDatabase orderDatabase = new ConfigurableOrderDatabase();
        List<Order> gotOrders = new ArrayList<>();
        orderDatabase.doWhenInsertCalled = order -> gotOrders.add(order) ;
        orderDatabase.doWhenSelectAllOrdersCalled = () -> gotOrders;
        orderDatabase.connect();
        orderDatabase.clean();
        OrderProcessing orderProcessing = new OrderProcessing(orderDatabase, new FileLog());
        Order order = new Order("customer 1", "", "product 1", Instant.now(), 1);

        // When
        orderProcessing.place(order);
        
        // Then
        List<Order> allOrders = orderDatabase.selectAllOrders();
        assertThat(allOrders).contains(order);
    }

}
