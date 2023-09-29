package com.farhad.example.factory_method.pizastore.pizzastores;

import com.farhad.example.factory_method.pizastore.pizzas.NYStyleCheesePizza;
import com.farhad.example.factory_method.pizastore.pizzas.NYStyleClamPizza;
import com.farhad.example.factory_method.pizastore.pizzas.NYStylePepperoniPizza;
import com.farhad.example.factory_method.pizastore.pizzas.NYStyleVeggiePizza;
import com.farhad.example.factory_method.pizastore.pizzas.Pizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        
            if(type.equals("cheese")) {
                return new NYStyleCheesePizza();
            } else if (type.equals("veggie")) {
                return new NYStyleVeggiePizza();
            } else if (type.equals("clam")) {
                return new NYStyleClamPizza();
            } else if (type.equals("pepperoni")) {
                return new NYStylePepperoniPizza();
            } else {
                return null;
            }
    }
    
}
