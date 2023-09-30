package com.farhad.example.factory_method.pizastore.pizzas;

import com.farhad.example.factory_method.pizastore.ingredient_factories.cheese.Cheese;
import com.farhad.example.factory_method.pizastore.ingredient_factories.clams.Clams;
import com.farhad.example.factory_method.pizastore.ingredient_factories.dough.Dough;
import com.farhad.example.factory_method.pizastore.ingredient_factories.pepperoni.Pepperoni;
import com.farhad.example.factory_method.pizastore.ingredient_factories.sauce.Sauce;
import com.farhad.example.factory_method.pizastore.ingredient_factories.veggies.Veggies;

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

// Each pizza holds a set of ingredients that are used in its preparation.
// 
// We’ve now made the prepare method abstract. This is where we are going to collect the
// ingredients needed for the pizza, which of course will come from the ingredient factory.
public abstract class Pizza {

    @Getter
    String name;

    Dough dough;

    Sauce sauce; 
    
    Veggies[] veggies;

    Cheese cheese;

    Pepperoni pepperoni;

    Clams clams;


    // List<String> toppings = new ArrayList<>();

    public abstract void prepare();
    // public void prepare() {
    //     System.out.println("Preparing " + name);
    //     System.out.println("Tossing dough..." );
    //     System.out.println("Adding sauce... ");
    //     System.out.println("Adding toppings...");
    //     for (String topping : toppings) {
    //         System.out.println("    " + topping);
    //     }
    // }

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
