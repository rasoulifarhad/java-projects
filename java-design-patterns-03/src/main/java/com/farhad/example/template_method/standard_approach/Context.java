package com.farhad.example.template_method.standard_approach;

public class Context {
    
    public static void main(String[] args) {
        
        AbstractClass class1 = new ClassA();
        class1.templateMethod();

        System.out.println();

        AbstractClass class2 = new ClassB();
        class2.templateMethod();
    }
}
