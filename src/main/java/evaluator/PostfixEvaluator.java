package evaluator;

import stack.Stack;

public class PostfixEvaluator {

    private Stack<Integer> stack;

    public PostfixEvaluator(Stack<Integer> stack) {
        this.stack = stack;
    }

    public int evaluate(String expression) {
        String[] tokens = expression.split(" ");

        for (String token : tokens) {

            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private boolean isNumber(String token) {
        return token.matches("\\d+");
    }

    private int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new RuntimeException("Operador inválido");
        }
    }
}