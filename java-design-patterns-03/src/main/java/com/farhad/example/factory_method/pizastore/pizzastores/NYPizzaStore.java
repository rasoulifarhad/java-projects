package com.farhad.example.factory_method.pizastore.pizzastores;

import com.farhad.example.factory_method.pizastore.ingredient_factories.NYPizzaIngredientFactory;
import com.farhad.example.factory_method.pizastore.ingredient_factories.PizzaIngredientFactory;
import com.farhad.example.factory_method.pizastore.pizzas.CheesePizza;
import com.farhad.example.factory_method.pizastore.pizzas.ClamPizza;
import com.farhad.example.factory_method.pizastore.pizzas.PepperoniPizza;
import com.farhad.example.factory_method.pizastore.pizzas.Pizza;
import com.farhad.example.factory_method.pizastore.pizzas.VeggiePizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
            Pizza pizza =null;
            PizzaIngredientFactory factory = new NYPizzaIngredientFactory();
            if(type.equals("cheese")) {
                pizza = new CheesePizza(factory);
                pizza.setName("New York Style Cheese Pizza");
            } else if (type.equals("veggie")) {
                pizza = new VeggiePizza(factory);
                pizza.setName("New York Style Veggie Pizza");
            } else if (type.equals("clam")) {
                pizza = new ClamPizza(factory);
                pizza.setName("New York Style Clam Pizza");
            } else if (type.equals("pepperoni")) {
                pizza = new PepperoniPizza(factory);
                pizza.setName("New York Style Pepperoni Pizza");
            } 

            return pizza;
    }
    
}
