package com.farhad.example.bit_manipulation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

public class SwapValues {

    @AllArgsConstructor
    @Getter
    @EqualsAndHashCode
    static class Pair {
        int a;
        int b;

        public void swap() {
            int temp = a;
            a = b;
            b = temp;
        }
        // a = a ^ b; b = a ^ b ^ b; a = a ^ b ^ b ^ a
        public void swapBW() {

            a = a ^ b;
            b = a ^ b;
            a = b ^ a;// a = a ^ b
        }
    }

    public Pair swapValues(Pair original) {
        original.swap();
        return original;
    }

    public Pair swapValuesBW(Pair original) {
        original.swapBW();
        return original;
    }    
}
