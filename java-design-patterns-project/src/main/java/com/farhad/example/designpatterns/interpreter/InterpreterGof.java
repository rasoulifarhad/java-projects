package com.farhad.example.designpatterns.interpreter;

import java.util.Stack;

import lombok.AllArgsConstructor;

public class InterpreterGof {
    
    interface Expression {
        int interpret();
    }

    
    public static class  Number implements Expression {
        private int number;

        public Number(int number) {
            this.number = number;
        }

        public Number(String number) {
            this.number = Integer.parseInt(number);
        }

        @Override
        public int interpret() {
            return number;
        }

    }

    @AllArgsConstructor
    public static class  Add implements Expression {

        private Expression firstExpression, secondExpression;
        
        @Override
        public int interpret() {
            return firstExpression.interpret() + secondExpression.interpret();
        }

        public String toString() {
            return "+";
        }


    }

    @AllArgsConstructor
    public static class  Subtract implements Expression {

        private Expression firstExpression, secondExpression;
        
        @Override
        public int interpret() {
            return firstExpression.interpret() - secondExpression.interpret();
        }

        public String toString() {
            return "-";
        }
    }

    @AllArgsConstructor
    public static class  Multiplication implements Expression {

        private Expression firstExpression, secondExpression;
        
        @Override
        public int interpret() {
            return firstExpression.interpret() * secondExpression.interpret();
        }

        public String toString() {
            return "*";
        }


    }

    public static class Context {

    }

    public static class ExpressionParser {

        Stack<Expression> stack = new Stack<>();

        public int parse(String str) {
            String [] tokens = str.split(" ");
            for (String symbol : tokens) {
                if(!ParserUtil.isOperator(symbol)) {
                    Expression numberExpression = new Number(symbol);
                    stack.push(numberExpression);
                    System.out.println(String.format("Pushed to stack: %d%n", numberExpression.interpret()));
                } if (ParserUtil.isOperator(symbol)) {
                    Expression firstExpression = stack.pop();
                    Expression secondExpression = stack.pop();
                    System.out.println(String.format("Popped operands %d and % d%n", firstExpression.interpret(), secondExpression.interpret()));
                    Expression operator = ParserUtil.getExpressionObject(firstExpression, secondExpression, symbol);
                    System.out.println(String.format("Applying operator: %s%n", operator));
                    int result = operator.interpret();
                    Expression resultExpression = new Number(result);
                    stack.push(resultExpression);
                    System.out.println(String.format("Pushed result to stack: %d%n", resultExpression.interpret()));
            
                }
            }
            Expression expression = stack.pop();
            return expression.interpret();
        }
    }

    static class ParserUtil  {

        public static Expression getExpressionObject(Expression firstExpression, Expression secondExpression, String symbol) {
            if (symbol.equals("+")) {
                return new Add(firstExpression, secondExpression);
            }
            if (symbol.equals("-")) {
                return new Subtract(firstExpression, secondExpression);
            }
            if (symbol.equals("*")) {
                return new Multiplication(firstExpression, secondExpression);
            } else {
                throw new IllegalArgumentException("symbol unknown "  + symbol);
            }

        }

        public static boolean isOperator(String symbol) {
            return symbol.equals("-") || symbol.equals("+") || symbol.equals("*");
        }
}
    
}
