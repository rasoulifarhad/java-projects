package com.farhad.example.factory_method.pizastore.pizzas;

import com.farhad.example.factory_method.pizastore.ingredient_factories.PizzaIngredientFactory;

public class NYStyleCheesePizza extends Pizza {
    
    private PizzaIngredientFactory pizzaIngredientFactory ;

    public NYStyleCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        name = "NY Style Sauce and Cheese Pizza";
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    // public NYStyleCheesePizza() {
    //     name = "NY Style Sauce and Cheese Pizza";
    //     dough = "Thin Crust Dough";
    //     sauce = "Marinara Sauce";
    //     toppings.add("Grated Reggiano Cheese");
    // }

    @Override
    public void prepare() {
        System.out.println("preparing " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }
}
