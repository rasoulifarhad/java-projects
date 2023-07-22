package com.farhad.example.designpatterns.interpreter;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.interpreter.InterpreterGof.ExpressionParser;

public class InterpreterGof_ExpressionParserTest {

    @Test
    void testParse() {
        String input = "2 1 5 + *";
        System.out.println(input);
        ExpressionParser expressionParser = new ExpressionParser();
        int result = expressionParser.parse(input);
        System.out.println("Final result:  " + result);

        System.out.println();
        input = "7 3 - 2 1 + *";
        System.out.println(input);
        result = expressionParser.parse(input);
        System.out.println("Final result:  " + result);
    }
}
