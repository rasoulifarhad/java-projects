package com.farhad.example.factory_method.pizastore.pizzastores;

import com.farhad.example.factory_method.pizastore.ingredient_factories.ChicagoPizzaIngredientFactory;
import com.farhad.example.factory_method.pizastore.ingredient_factories.NYPizzaIngredientFactory;
import com.farhad.example.factory_method.pizastore.ingredient_factories.PizzaIngredientFactory;
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

        } else if(style.equals("Chicago")) {

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
