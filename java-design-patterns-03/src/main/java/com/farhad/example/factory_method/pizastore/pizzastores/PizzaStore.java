package com.farhad.example.factory_method.pizastore.pizzastores;

import com.farhad.example.factory_method.pizastore.pizzas.Pizza;

// Factory Method: Both Abstract Factory and
// I create objects – that’s our jobs. But I do it through
// inheritance...
// 
// Abstract Factory: ...and I do it through object
// composition.
// 
// Abstract Factory, often use factory methods to implement your concrete factories?
// concrete factories often implement a factory method to create their products.

// Abstract Factory: Thanks. Remember me, Abstract
// Factory, and use me whenever you have families of
// products you need to create and you want to make sure
// your clients create products that belong together.
// 
// Factory Method: And I’m Factory Method; use me to
// decouple your client code from the concrete classes you
// need to instantiate, or if you don’t know ahead of time
// all the concrete classes you are going to need. To use me,
// just subclass me and implement my factory method!
// 
// The intent of Factory Method is to allow a class to defer instantiation to its 
// subclasses.
// 
// The intent of Abstract Factory is to create families of related objects without having 
// to depend on their concrete classes.
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
