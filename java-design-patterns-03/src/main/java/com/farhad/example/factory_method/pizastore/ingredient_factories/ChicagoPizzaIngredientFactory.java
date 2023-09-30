package com.farhad.example.factory_method.pizastore.ingredient_factories;

import com.farhad.example.factory_method.pizastore.ingredient_factories.cheese.Cheese;
import com.farhad.example.factory_method.pizastore.ingredient_factories.cheese.MozzarellaCheese;
import com.farhad.example.factory_method.pizastore.ingredient_factories.clams.Clams;
import com.farhad.example.factory_method.pizastore.ingredient_factories.clams.FrozenClams;
import com.farhad.example.factory_method.pizastore.ingredient_factories.dough.Dough;
import com.farhad.example.factory_method.pizastore.ingredient_factories.dough.ThickCrustDough;
import com.farhad.example.factory_method.pizastore.ingredient_factories.pepperoni.Pepperoni;
import com.farhad.example.factory_method.pizastore.ingredient_factories.pepperoni.SlicedPepperoni;
import com.farhad.example.factory_method.pizastore.ingredient_factories.sauce.PlumTomatoSauce;
import com.farhad.example.factory_method.pizastore.ingredient_factories.sauce.Sauce;
import com.farhad.example.factory_method.pizastore.ingredient_factories.veggies.BlackOlives;
import com.farhad.example.factory_method.pizastore.ingredient_factories.veggies.EggPlant;
import com.farhad.example.factory_method.pizastore.ingredient_factories.veggies.Parmesan;
import com.farhad.example.factory_method.pizastore.ingredient_factories.veggies.Spinach;
import com.farhad.example.factory_method.pizastore.ingredient_factories.veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new BlackOlives(), new Spinach(), new EggPlant(), new Parmesan() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }

}
