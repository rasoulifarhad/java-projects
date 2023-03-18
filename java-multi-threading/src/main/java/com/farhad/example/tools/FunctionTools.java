package com.farhad.example.tools;

import java.util.function.Function;

public class FunctionTools {
    
    public static <T,R> Function<T,R> wrap( CheckedFunction<T,R> checkedFunction ) {
        return t -> {
            try {
                return checkedFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
