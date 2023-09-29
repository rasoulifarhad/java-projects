package com.farhad.example.template_method.standard_approach;

public class ClassA extends AbstractClass {

    public ClassA() {
        super("ClassA");
    }

    @Override
    protected void primitiveOperation1() {
        System.out.println("ClassA primitiveOperation1");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("ClassA primitiveOperation2");
    }
    
}
