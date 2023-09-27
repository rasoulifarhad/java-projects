package com.farhad.example.functional_interface.function_holder;

import java.util.function.BinaryOperator;

public class InterfaceContainingFunction {
    
    public interface Multiply {
        BinaryOperator<Integer> DIRECTMUL = (a, b) -> a * b;
        BinaryOperator<Integer> DIRECTMULothermul = (a, b) -> otherMul(a, b);

        public static Integer otherMul(Integer a, Integer b) {
            return a * b;
        }
        
    }


    public static void main(String[] args) {
        System.out.println(Multiply.DIRECTMUL.apply(3, 4));
    }
}
