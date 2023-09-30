package com.farhad.example.factory_method.pizastore.ingredient_factories;

import com.farhad.example.factory_method.pizastore.ingredient_factories.cheese.Cheese;
import com.farhad.example.factory_method.pizastore.ingredient_factories.clams.Clams;
import com.farhad.example.factory_method.pizastore.ingredient_factories.dough.Dough;
import com.farhad.example.factory_method.pizastore.ingredient_factories.pepperoni.Pepperoni;
import com.farhad.example.factory_method.pizastore.ingredient_factories.sauce.Sauce;
import com.farhad.example.factory_method.pizastore.ingredient_factories.veggies.Veggies;

// Build a factory for each region. To do this, you’ll create a subclass of PizzaIngredientFactory that implements each create method
// Implement a set of ingredient classes to be used with the factory, like ReggianoCheese, RedPeppers, and ThickCrustDough. These classes can be shared among regions where appropriate.
// Then we still need to hook all this up by working our new ingredient factories into our old PizzaStore code.
public interface PizzaIngredientFactory {
    
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClam();
}
