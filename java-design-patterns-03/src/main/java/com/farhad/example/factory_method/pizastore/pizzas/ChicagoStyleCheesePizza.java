package com.farhad.example.factory_method.pizastore.pizzas;

import com.farhad.example.factory_method.pizastore.ingredient_factories.PizzaIngredientFactory;

public class ChicagoStyleCheesePizza extends Pizza {
    
    private PizzaIngredientFactory pizzaIngredientFactory ;

    public ChicagoStyleCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        name = "Chicago Style Deep Dish Cheese Pizza";
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    // public ChicagoStyleCheesePizza() {
    //     name = "Chicago Style Deep Dish Cheese Pizza";
    //     dough = "Extra Thick Crust Dough";
    //     sauce = "Plum Tomato Sauce";
    //     toppings.add("Shredded Mozzarella Cheese");
    // }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }

    @Override
    public void prepare() {
        System.out.println("preparing " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }

    
}
