package com.farhad.example.template_method.standard_approach;

public abstract class AbstractClass {
    
    protected String description;


    public AbstractClass(String description) {
        this.description = description;
    }

    public final void templateMethod() {
        setup();
        primitiveOperation1();
        primitiveOperation2();
        teardown();
    }

    private void setup() {
        System.out.println("Setup " + description);
    }

    private void teardown() {
        System.out.println("teardown " + description);
    }

    protected abstract void primitiveOperation1() ;
    protected abstract void primitiveOperation2() ;
}
