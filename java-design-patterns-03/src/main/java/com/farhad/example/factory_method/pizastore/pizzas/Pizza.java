package com.farhad.example.factory_method.pizastore.pizzas;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
//
// Chicago pizza menu
// 
// - Cheese Pizza
//     Plum Tomato Sauce, Mozzarella, Parmesan, 
//     Oregano
// - Veggie Pizza
//     Plum Tomato Sauce, Mozzarella, Parmesan, 
//     Eggplant, Spinach, Black Olives
// - Clam Pizza
//     Plum Tomato Sauce, Mozzarella, Parmesan, 
//     clams
// - Pepperoni Pizza
//     Plum Tomato Sauce, Mozzarella, Parmesan, 
//     Eggplant, Spinach, Black Olives, Pepperoni
// 
// New York pizza menu
// 
// - Cheese Pizza
//     Marinara Sauce, Reggiano, Garlic
// - Veggie Pizza
//     Marinara Sauce, Reggiano, Mushrooms, 
//     Onions, Red Peppers
// - Clam Pizza 
//     Marinara Sauce, Reggiano, Fresh Clams
// - Pepperoni Pizza 
//     Marinara Sauce, Reggiano, Mushrooms, 
//     Onions, Red Peppers, Pepperoni
// 
// We’ve got the same product families (dough, sauce, cheese, veggies, meats) but different 
// implementations based on region.
//
public abstract class Pizza {

    @Getter
    String name;

    String dough;

    String sauce; 

    List<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough..." );
        System.out.println("Adding sauce... ");
        System.out.println("Adding toppings...");
        for (String topping : toppings) {
            System.out.println("    " + topping);
        }

    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");        
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");        
    }

    public void box() {
        System.out.println("Place pizza in ofﬁcial PizzaStore box");        
    }

}
