package converter;

import stack.Stack;

public class InfixToPostfixConverter {

    private Stack<String> stack;

    public InfixToPostfixConverter(Stack<String> stack) {
        this.stack = stack;
    }

    public String convert(String expression) {
        StringBuilder output = new StringBuilder();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {

            if (isNumber(token)) {
                output.append(token).append(" ");
            } else if (isOperator(token)) {
                while (!stack.isEmpty() &&
                        precedence(stack.peek()) >= precedence(token)) {
                    output.append(stack.pop()).append(" ");
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.peek().equals("(")) {
                    output.append(stack.pop()).append(" ");
                }
                stack.pop(); // remove "("
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }

        return output.toString().trim();
    }

    private boolean isNumber(String token) {
        return token.matches("\\d+");
    }

    private boolean isOperator(String token) {
        return token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/");
    }

    private int precedence(String operator) {
        if (operator.equals("+") || operator.equals("-"))
            return 1;
        if (operator.equals("*") || operator.equals("/"))
            return 2;
        return 0;
    }
}