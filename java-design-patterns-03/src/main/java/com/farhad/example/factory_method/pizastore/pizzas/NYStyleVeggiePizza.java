package com.farhad.example.factory_method.pizastore.pizzas;

import com.farhad.example.factory_method.pizastore.ingredient_factories.PizzaIngredientFactory;

public class NYStyleVeggiePizza extends Pizza {
    
    private PizzaIngredientFactory pizzaIngredientFactory ;

    public NYStyleVeggiePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("preparing " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }

}
