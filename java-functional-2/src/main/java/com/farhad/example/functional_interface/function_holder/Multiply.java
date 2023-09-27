package com.farhad.example.functional_interface.function_holder;

public enum Multiply {
    DIRECTMUL {
    
        @Override
        public Integer apply(Integer a, Integer b) {
            return a * b;
        }

    },
    OTHERMUL {

        @Override
        public Integer apply(Integer a, Integer b) {
            return otherMul(a, b);
        }

    };

    public abstract Integer apply(Integer a, Integer b);

    private static Integer otherMul(Integer a, Integer b) {
        return a * b;
    }

    public static void main(String[] args) {
        System.out.println(Multiply.DIRECTMUL.apply(1, 3));
        System.out.println(Multiply.OTHERMUL.apply(1, 3));
    }
}


