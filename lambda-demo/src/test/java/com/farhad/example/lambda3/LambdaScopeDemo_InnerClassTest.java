package com.farhad.example.lambda3;

import org.junit.jupiter.api.Test;

public class LambdaScopeDemo_InnerClassTest {
    @Test
    void testInnerClassMethode() {
        LambdaScopeDemo lambdaScopeDemo = new LambdaScopeDemo();
        LambdaScopeDemo.InnerClass innerClass = lambdaScopeDemo.new InnerClass();
        innerClass.innerClassMethode(12);

    }
}
