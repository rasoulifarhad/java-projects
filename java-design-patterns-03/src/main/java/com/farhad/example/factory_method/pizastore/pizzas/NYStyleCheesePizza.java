package com.farhad.example.factory_method.pizastore.pizzas;

import com.farhad.example.factory_method.pizastore.ingredient_factories.PizzaIngredientFactory;

public class NYStyleCheesePizza extends Pizza {
    
    private PizzaIngredientFactory pizzaIngredientFactory ;

    public NYStyleCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        name = "NY Style Sauce and Cheese Pizza";
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    // The prepare() method steps through creating
    // a cheese pizza, and each time it needs an 
    // ingredient, it asks the factory to produce it.
    @Override
    public void prepare() {
        System.out.println("preparing " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }
}
