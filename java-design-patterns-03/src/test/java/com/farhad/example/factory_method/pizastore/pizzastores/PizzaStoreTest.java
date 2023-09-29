package com.farhad.example.factory_method.pizastore.pizzastores;

import org.junit.jupiter.api.Test;

import com.farhad.example.factory_method.pizastore.pizzas.Pizza;

public class PizzaStoreTest {

    @Test
    public void test() {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        Pizza pizza = nyPizzaStore.ordePizza("cheese");
        System.out.println("ordered a " + pizza.getName() ); 
        
        pizza = chicagoPizzaStore.ordePizza("cheese");
        System.out.println("ordered a " + pizza.getName() ); 

    }
}
