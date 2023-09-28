package com.farhad.example.functional_interface.vehicle_demo.with_try.toolkit;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public interface Try<T> {
    
    T getValue();
    boolean isFailure();
    Exception getCause();
    Try<T> map(UnaryOperator<T> f);
    Try<T> flatMap(Function<T, Try<T>> f);

    default boolean isSuccess(){
        return !isFailure();
    }

    public static <T> Try<T> of(Supplier<T> supplier) {
        try {
            return new Success<>(supplier.get());
        } catch (Exception e) {
            return new Failure<>(e);
        }
    }

    class Success<T> implements Try<T>  {

        private T value;
        
        public Success(final T value) {
            this.value = value;
        }

        @Override
        public T getValue() {
            return value;
        }

        @Override
        public boolean isFailure() {
            return false;
        }

        @Override
        public Exception getCause() {
            return null;
        }

        @Override
        public Try<T> map(UnaryOperator<T> f) {
            return Try.of(() -> f.apply(getValue()));
        }

        @Override
        public Try<T> flatMap(Function<T, Try<T>> f) {
            return Try.of(() -> f.apply(getValue()).getValue());
        }

    }

    class Failure<T> implements Try<T>  {

        private final Exception exception;


        public Failure(Exception exception) {
            this.exception = exception;
        }

        @Override
        public T getValue() {
            return null;
        }

        @Override
        public boolean isFailure() {
            return true;
        }

        @Override
        public Exception getCause() {
            return exception;
        }

        @Override
        public Try<T> map(UnaryOperator<T> f) {
            return this;
        }

        @Override
        public Try<T> flatMap(Function<T, Try<T>> f) {
            return this;
        }
    }
}
