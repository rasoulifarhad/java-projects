package com.farhad.example.factory_method.pizastore.pizzastores;

import com.farhad.example.factory_method.pizastore.ingredient_factories.NYPizzaIngredientFactory;
import com.farhad.example.factory_method.pizastore.ingredient_factories.PizzaIngredientFactory;
import com.farhad.example.factory_method.pizastore.pizzas.NYStyleCheesePizza;
import com.farhad.example.factory_method.pizastore.pizzas.NYStyleClamPizza;
import com.farhad.example.factory_method.pizastore.pizzas.NYStylePepperoniPizza;
import com.farhad.example.factory_method.pizastore.pizzas.NYStyleVeggiePizza;
import com.farhad.example.factory_method.pizastore.pizzas.Pizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
            Pizza pizza =null;
            PizzaIngredientFactory factory = new NYPizzaIngredientFactory();
            if(type.equals("cheese")) {
                pizza = new NYStyleCheesePizza(factory);
                pizza.setName("New York Style Cheese Pizza");
            } else if (type.equals("veggie")) {
                pizza = new NYStyleVeggiePizza(factory);
                pizza.setName("New York Style Veggie Pizza");
            } else if (type.equals("clam")) {
                pizza = new NYStyleClamPizza(factory);
                pizza.setName("New York Style Clam Pizza");
            } else if (type.equals("pepperoni")) {
                pizza = new NYStylePepperoniPizza(factory);
                pizza.setName("New York Style Pepperoni Pizza");
            } 

            return pizza;
    }
    
}
