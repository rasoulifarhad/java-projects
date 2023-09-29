package com.farhad.example.factory_method.pizastore.pizzastores;

import com.farhad.example.factory_method.pizastore.pizzas.Pizza;

public abstract class PizzaStore {

    public Pizza ordePizza(String type) {
        Pizza pizza ;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;        
    }

    // A factory method handles object creation and encapsulates it in
    // a subclass. This decouples the client code in the superclass from
    // the object creation code in the subclass.
    //
    // abstract Product factoryMethod(String type)
    //
    // - A factory method is abstract so the subclasses are counted on to handle 
    //   object creation.
    // - A factory method returns a Product that is typically used within methods 
    //   defined in the superclass.
    // - A factory method isolate the client(the code in the superclass, like 
    //   orderPizza()) from knowing what kind of concrete Product is actually 
    //   created.
    // - A factory method may be parameterized (or not) to select among several 
    //   variations of a product.
    public abstract Pizza createPizza(String type);
}
