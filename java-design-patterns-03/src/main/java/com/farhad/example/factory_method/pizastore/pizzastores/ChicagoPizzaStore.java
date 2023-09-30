package com.farhad.example.factory_method.pizastore.pizzastores;

import com.farhad.example.factory_method.pizastore.ingredient_factories.ChicagoPizzaIngredientFactory;
import com.farhad.example.factory_method.pizastore.ingredient_factories.PizzaIngredientFactory;
import com.farhad.example.factory_method.pizastore.pizzas.ChicagoStyleCheesePizza;
import com.farhad.example.factory_method.pizastore.pizzas.ChicagoStyleClamPizza;
import com.farhad.example.factory_method.pizastore.pizzas.ChicagoStylePepperoniPizza;
import com.farhad.example.factory_method.pizastore.pizzas.ChicagoStyleVeggiePizza;
import com.farhad.example.factory_method.pizastore.pizzas.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
            Pizza pizza =null;
            PizzaIngredientFactory factory = new ChicagoPizzaIngredientFactory();
            if(type.equals("cheese")) {
                pizza = new ChicagoStyleCheesePizza(factory);
                pizza.setName("Chicago Style Cheese Pizza");
            } else if (type.equals("veggie")) {
                pizza = new ChicagoStyleVeggiePizza(factory);
                pizza.setName("Chicago Style Veggie Pizza");
            } else if (type.equals("clam")) {
                pizza = new ChicagoStyleClamPizza(factory);
                pizza.setName("Chicago Style Clam Pizza");
            } else if (type.equals("pepperoni")) {
                pizza = new ChicagoStylePepperoniPizza(factory);
                pizza.setName("Chicago Style Pepperoni Pizza");
            } 

            return pizza;
    }
    
}
