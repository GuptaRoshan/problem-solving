package neetcode150.stack;

import java.util.Stack;

public class PolishNotation_150 {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {

            switch (token) {
                // if -> break is not needed
                case "+" -> {
                    int x = Integer.parseInt(stack.pop());
                    int y = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(y + x));
                }
                case "-" -> {
                    int x = Integer.parseInt(stack.pop());
                    int y = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(y - x));
                }
                case "*" -> {
                    int x = Integer.parseInt(stack.pop());
                    int y = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(y * x));
                }
                case "/" -> {
                    int x = Integer.parseInt(stack.pop());
                    int y = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(y / x));
                }

                default -> stack.push(token);
            }

        }

        return Integer.parseInt(stack.pop());
    }


    public static void main(String[] args) {
        PolishNotation_150 polishNotation150 = new PolishNotation_150();
        String[] tokens = {"4", "13", "5", "/", "+"}; // Output : 6
        System.out.println(polishNotation150.evalRPN(tokens));
    }
}
