package neetcode150.stack;

import java.util.Stack;

public class ValidParentheses_20 {

    public static boolean isValid(String s) {
        // Edge case when char is empty and the length of char is odd
        if (s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()){
                return false;
            }

            if (stack.peek() == '(' && ch == ')' || stack.peek() == '[' && ch == ']' || stack.peek() == '{' && ch == '}') {
                stack.pop();
                continue;
            }

            return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Valid  :" + isValid("()[]{}"));
        System.out.println("Invalid :" + isValid("(]"));
    }
}
