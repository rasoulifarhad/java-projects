package com.farhad.example.tools;

import java.util.function.Function;

/**
 * 
 *   myList.stream()
 *     .map(this::trySomething)
 *     .forEach(System.out::println);
 *   
 *   private Item trySomething(Item item) {
 *     try {
 *       return doSomething(item);
 *     } catch (MyException e) {
 *       throw new RuntimeException(e);
 *     }
 *   }
 * 
 * If you want to wrap every call in a lambda that has a checked into a RuntimeException, you will see that you repeat the same 
 * pattern. To avoid rewriting the same code over and over again, why not abstract it into a utility function? 
 * 
 * This way, you only have to write it once and call it every time you need it.
 * 
 * To do so, you first need to write your own version of the functional interface for a function. 
 * 
 * Now, you are ready to write your own general utility function that accepts a CheckedFunction as you just described in the 
 * interface.You can handle the try-catch in this utility function and wrap the original exception into a RuntimeException 
 * (or some other unchecked variant). 
 * 
 *   myList.stream()
 *          .map(wrap(item -> doSomething(item)))
 *          .forEach(System.out::println);
 * 
 * The only problem left is that when an exception occurs, the processing of the your stream stops immediately.
 * 
 */ 
@FunctionalInterface
public interface CheckedFunction<T,R> {
    R apply(T t) throws Exception;

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
