package leetcode.stack;

import java.util.Stack;

public class RemoveOutermostParentheses {

    public static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                if (stack.size() > 1) {
                    result.append(s.charAt(i));
                }
            } else {
                if (stack.size() > 1) {
                    result.append(s.charAt(i));
                }

                stack.pop();
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String p = "()()";
        System.out.println(removeOuterParentheses(p));
    }
}
