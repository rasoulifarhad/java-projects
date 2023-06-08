package com.farhad.example.lambda2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MethodReferencesDemoTest {

    MethodReferencesDemo demo ;

    @BeforeEach
    public void setup() {
        demo = new MethodReferencesDemo();
    }

    @AfterEach 
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstratePersonSortWithLambdaExpression() {
        demo.demonstratePersonSortWithLambdaExpression();
    }

    @Test
    void testDemonstratePersonSortWithLambdaExpressionAndCompareByAgeMethodOfPerson() {
        demo.demonstratePersonSortWithLambdaExpressionAndCompareByAgeMethodOfPerson();
    }

    @Test
    void testDemonstratePersonSortWithMethodReference() {
        demo.demonstratePersonSortWithMethodReference();
    }

    @Test
    void testDemonstratePersonSortWithoutMethodReference() {
        demo.demonstratePersonSortWithoutMethodReference();
    }

    @Test
    void testDemonstratePersonSortWithLambdaExpressionAndCompareByAgeMethodOfPerson2() {
        demo.demonstrateDiferentMethodReferenceUsageWithMergeThings();
    }

    @Test
    void testDemonstrateDiferentMethodReferenceUsageWithMergeThings() {
        demo.demonstrateDiferentMethodReferenceUsageWithMergeThings();
    }

    @Test
    void testDemonstrateReferenceToAnInstanceMethodOfAnArbitraryObjectOfParticularType() {
        demo.demonstrateReferenceToAnInstanceMethodOfAnArbitraryObjectOfParticularType();        
    }

    @Test
    void testDemonstrateReferenceToAnInstanceMethodOfParticularObject() {
        demo.demonstrateReferenceToAnInstanceMethodOfParticularObject();
    }

    @Test
    public void testDemonstrateReferenceToConstructor() {
        demo.demonstrateReferenceToConstructor();
    }
}
