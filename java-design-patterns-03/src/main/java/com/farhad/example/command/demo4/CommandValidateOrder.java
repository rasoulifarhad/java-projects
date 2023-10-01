package com.farhad.example.command.demo4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommandValidateOrder  implements Command{

    private Order order;

    @Override
    public void execute() {
        order.setOrderValidated(true);
        System.out.println(order);
    }
}
