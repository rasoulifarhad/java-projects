package com.farhad.example.designpatterns.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.IntBinaryOperator;

public class InterpreterLambda {
    
    static Map<String, IntBinaryOperator> opMap = new HashMap<>();

    static {
        opMap.put("+", (left, right) -> left + right);
        opMap.put("-", (left, right) -> left - right);
        opMap.put("*", (left, right) -> left * right);
    }

    public static class ExpressionParser {
        Stack<Integer> stack = new Stack<>();

        public int parse(String exp){
            for(String symbol : exp.split(" ")) {
                IntBinaryOperator op =  opMap.get(symbol);
                if (op != null) {
                    int left = stack.pop();
                    int right = stack.pop();
                    stack.push(op.applyAsInt(left, right));
                } else {
                    stack.push(Integer.parseInt(symbol));
                }
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        String input = "7 3 - 2 1 + *";
        System.out.println(parser.parse(input));
    }

}
