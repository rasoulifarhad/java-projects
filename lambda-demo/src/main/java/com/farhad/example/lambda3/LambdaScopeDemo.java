package com.farhad.example.lambda3;

import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaScopeDemo {
    
    public int x = 0;

    class InnerClass {

        public int x = 1 ;

        void innerClassMethode(int x) {

            int z = 2;

            Consumer<Integer> consumer = y -> {

                // Error, z must be final 
                // z = 10 ;
                int z2 = z;

                log.info("x = {}", x);
                log.info("y = {}", y);
                log.info("z = {}", z);
                log.info("z2 = {}", z2);
                log.info("this.x = {}", this.x);
                log.info("LambdaScopeDemo.this = {}", LambdaScopeDemo.this.x);
            } ;
            consumer.accept(x);
        }
    }

    public static void main(String[] args) {
        LambdaScopeDemo lambdaScopeDemo = new LambdaScopeDemo();
        LambdaScopeDemo.InnerClass innerClass = lambdaScopeDemo.new InnerClass();
        innerClass.innerClassMethode(12);
    }
}
