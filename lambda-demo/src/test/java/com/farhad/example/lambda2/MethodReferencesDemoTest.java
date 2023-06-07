package com.farhad.example.lambda2;

import org.junit.jupiter.api.Test;

public class MethodReferencesDemoTest {
    @Test
    void testDemonstratePersonSortWithLambdaExpression() {
        MethodReferencesDemo demo = new MethodReferencesDemo();
        demo.demonstratePersonSortWithLambdaExpression();
    }

    @Test
    void testDemonstratePersonSortWithLambdaExpressionAndCompareByAgeMethodOfPerson() {
        MethodReferencesDemo demo = new MethodReferencesDemo();
        demo.demonstratePersonSortWithLambdaExpressionAndCompareByAgeMethodOfPerson();
    }

    @Test
    void testDemonstratePersonSortWithMethodReference() {
        MethodReferencesDemo demo = new MethodReferencesDemo();
        demo.demonstratePersonSortWithMethodReference();
    }

    @Test
    void testDemonstratePersonSortWithoutMethodReference() {
        MethodReferencesDemo demo = new MethodReferencesDemo();
        demo.demonstratePersonSortWithoutMethodReference();
    }
}
