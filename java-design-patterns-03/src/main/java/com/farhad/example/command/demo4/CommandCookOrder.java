package com.farhad.example.command.demo4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommandCookOrder  implements Command{

    private Order order;

    @Override
    public void execute() {
        order.setOrderPrepared(true);
        System.out.println(order);
    }
}
