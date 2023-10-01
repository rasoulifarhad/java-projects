package com.farhad.example.command.demo4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommandPlaceOrder implements Command{

    private Order order;

    @Override
    public void execute() {
        order.setOrderPlaced(true);
        System.out.println(order);
    }
    
}
