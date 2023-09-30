package com.farhad.example.factory_method.pizastore.ingredient_factories;

import com.farhad.example.factory_method.pizastore.ingredient_factories.cheese.Cheese;
import com.farhad.example.factory_method.pizastore.ingredient_factories.cheese.ReggianoCheese;
import com.farhad.example.factory_method.pizastore.ingredient_factories.clams.Clams;
import com.farhad.example.factory_method.pizastore.ingredient_factories.clams.FreshClams;
import com.farhad.example.factory_method.pizastore.ingredient_factories.dough.Dough;
import com.farhad.example.factory_method.pizastore.ingredient_factories.dough.ThinCrustDough;
import com.farhad.example.factory_method.pizastore.ingredient_factories.pepperoni.Pepperoni;
import com.farhad.example.factory_method.pizastore.ingredient_factories.pepperoni.SlicedPepperoni;
import com.farhad.example.factory_method.pizastore.ingredient_factories.sauce.MarinaraSauce;
import com.farhad.example.factory_method.pizastore.ingredient_factories.sauce.Sauce;
import com.farhad.example.factory_method.pizastore.ingredient_factories.veggies.Garlic;
import com.farhad.example.factory_method.pizastore.ingredient_factories.veggies.Mushroom;
import com.farhad.example.factory_method.pizastore.ingredient_factories.veggies.Onion;
import com.farhad.example.factory_method.pizastore.ingredient_factories.veggies.RedPepper;
import com.farhad.example.factory_method.pizastore.ingredient_factories.veggies.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
    
}
