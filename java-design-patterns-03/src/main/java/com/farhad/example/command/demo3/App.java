package com.farhad.example.command.demo3;

public class App {
    
    public static void main(String[] args) {
        Stock abcStock = new Stock("ABC", 12);
        // Stock efgStock = new Stock("EFG", 5);

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
