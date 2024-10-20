package leetcode.stack;

import java.util.Stack;

public class RemoveDuplicatesString {

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == stack.peek()) {
                stack.pop();
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(s.charAt(i));
                stack.push(s.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "azxxzy";
        System.out.println(removeDuplicates(s));
    }
}
