package com.farhad.example.tdd.order;

import java.time.Instant;
import java.util.List;

public class AppTest {

    public static void main(String[] args) {
        
    }

    /**
     * 
     */
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

    }
}
