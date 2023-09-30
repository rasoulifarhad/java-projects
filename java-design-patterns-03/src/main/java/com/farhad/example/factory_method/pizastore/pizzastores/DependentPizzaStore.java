package com.farhad.example.factory_method.pizastore.pizzastores;

import com.farhad.example.factory_method.pizastore.ingredient_factories.ChicagoPizzaIngredientFactory;
import com.farhad.example.factory_method.pizastore.ingredient_factories.NYPizzaIngredientFactory;
import com.farhad.example.factory_method.pizastore.pizzas.ChicagoStyleCheesePizza;
import com.farhad.example.factory_method.pizastore.pizzas.ChicagoStyleClamPizza;
import com.farhad.example.factory_method.pizastore.pizzas.ChicagoStylePepperoniPizza;
import com.farhad.example.factory_method.pizastore.pizzas.ChicagoStyleVeggiePizza;
import com.farhad.example.factory_method.pizastore.pizzas.NYStyleCheesePizza;
import com.farhad.example.factory_method.pizastore.pizzas.NYStyleClamPizza;
import com.farhad.example.factory_method.pizastore.pizzas.NYStylePepperoniPizza;
import com.farhad.example.factory_method.pizastore.pizzas.NYStyleVeggiePizza;
import com.farhad.example.factory_method.pizastore.pizzas.Pizza;

public class DependentPizzaStore {
    
    public Pizza createPizza(String style, String type) {
        Pizza pizza = null;
        if (style.equals("NY")) {

            if(type.equals("cheese")) {
                pizza = new NYStyleCheesePizza(new NYPizzaIngredientFactory());
            } else if (type.equals("veggie")) {
                pizza = new NYStyleVeggiePizza(new NYPizzaIngredientFactory());
            } else if (type.equals("clam")) {
                pizza = new NYStyleClamPizza(new NYPizzaIngredientFactory());
            } else if (type.equals("pepperoni")) {
                pizza = new NYStylePepperoniPizza(new NYPizzaIngredientFactory());
            }

        } else if(style.equals("Chicago")) {

            if(type.equals("cheese")) {
                pizza = new ChicagoStyleCheesePizza(new ChicagoPizzaIngredientFactory());
            } else if (type.equals("veggie")) {
                pizza = new ChicagoStyleVeggiePizza(new ChicagoPizzaIngredientFactory());
            } else if (type.equals("clam")) {
                pizza = new ChicagoStyleClamPizza(new ChicagoPizzaIngredientFactory());
            } else if (type.equals("pepperoni")) {
                pizza = new ChicagoStylePepperoniPizza(new ChicagoPizzaIngredientFactory());
            }
        } else {
            System.out.println("Error: Invalid type of pizza");
            return null;
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
