package com.farhad.example.designpatterns.anotherDecorator;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.anotherDecorator.IcecreamDecoratorGof.HoneyDecorator;
import com.farhad.example.designpatterns.anotherDecorator.IcecreamDecoratorGof.Icecream;
import com.farhad.example.designpatterns.anotherDecorator.IcecreamDecoratorGof.NuttyDecorator;
import com.farhad.example.designpatterns.anotherDecorator.IcecreamDecoratorGof.SimpleIcecream;

public class IcecreamDecoratorGofTest {

    @Test
    public void testIcecream() {
        Icecream icecream = 
            new HoneyDecorator(
                new NuttyDecorator(
                    new SimpleIcecream()
                ));
        System.out.println(icecream.makeIcecream());
    }
}
