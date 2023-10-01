package com.farhad.example.command.demo4;

public class ClientCustomer {
    
    public static void main(String[] args) {
        
        Order myOrder = new Order("Veg Burger", 2);     
        
        CommandPlaceOrder commandPlaceOrder = new CommandPlaceOrder(myOrder);

        Waiter waiter = new Waiter();
        waiter.setCommand(commandPlaceOrder);
        waiter.takeOrder();

        CommandValidateOrder commandValidateOrder = new CommandValidateOrder(myOrder);
        Manager manager = new Manager();
        manager.setCommand(commandValidateOrder);
        manager.validateOrder();

        CommandCookOrder commandCookOrder = new CommandCookOrder(myOrder);
        Cook cook = new Cook();
        cook.setCommand(commandCookOrder);
        cook.prepareOrder();

        CommandServeOrder commandServeOrder = new CommandServeOrder(myOrder);
        waiter.setCommand(commandServeOrder);
        waiter.serveOrder();
    }
}
