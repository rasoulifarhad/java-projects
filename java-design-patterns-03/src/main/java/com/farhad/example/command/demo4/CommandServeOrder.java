package com.farhad.example.command.demo4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommandServeOrder  implements Command{

    private Order order;

    @Override
    public void execute() {
        order.setOrderServed(true);
        System.out.println(order);
    }

}
