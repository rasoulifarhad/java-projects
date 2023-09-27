package com.farhad.example.functional_interface;

public class FunctionFactory {
    
    public static IFunction getFunctiovAdd() {
        return (a, b) -> a +  b;
    }

    public static IFunction getFunctiovMul() {
        return (a, b) -> a *  b;
    }

    public static void main(String[] args) {
        IFunction mul = FunctionFactory.getFunctiovMul();
        System.out.println(mul.doFunction(1, 3));
    }
}
