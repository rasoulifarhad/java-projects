package com.farhad.example.factory_method.pizastore.pizzastores;

import com.farhad.example.factory_method.pizastore.ingredient_factories.ChicagoPizzaIngredientFactory;
import com.farhad.example.factory_method.pizastore.pizzas.ChicagoStyleCheesePizza;
import com.farhad.example.factory_method.pizastore.pizzas.ChicagoStyleClamPizza;
import com.farhad.example.factory_method.pizastore.pizzas.ChicagoStylePepperoniPizza;
import com.farhad.example.factory_method.pizastore.pizzas.ChicagoStyleVeggiePizza;
import com.farhad.example.factory_method.pizastore.pizzas.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        if(type.equals("cheese")) {
            return new ChicagoStyleCheesePizza(new ChicagoPizzaIngredientFactory());
        } else if (type.equals("veggie")) {
            return new ChicagoStyleVeggiePizza(new ChicagoPizzaIngredientFactory());
        } else if (type.equals("clam")) {
            return new ChicagoStyleClamPizza(new ChicagoPizzaIngredientFactory());
        } else if (type.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza(new ChicagoPizzaIngredientFactory());
        } else {
            return null;
        }
    }
    
}
