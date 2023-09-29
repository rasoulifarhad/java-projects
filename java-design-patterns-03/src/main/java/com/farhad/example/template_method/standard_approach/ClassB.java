package com.farhad.example.template_method.standard_approach;

public class ClassB extends AbstractClass {

    public ClassB() {
        super("ClassB");
    }

    @Override
    protected void primitiveOperation1() {
        System.out.println("ClassB primitiveOperation1");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("ClassB primitiveOperation2");
    }
    
}
