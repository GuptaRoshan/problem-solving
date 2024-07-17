package dataStructure.stack;

import java.util.Stack;

public class MonotonicStack {

    // Increasing Monotonic Stack
    public static void increasing(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        for (int number : numbers) {
            while (!stack.isEmpty() && stack.peek() > number) {
                stack.pop();
            }
            stack.push(number);
        }
        System.out.println(stack);
    }

    // Increasing Monotonic Stack
    public static void decreasing(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        for (int number : numbers) {
            while (!stack.isEmpty() && stack.peek() < number) {
                stack.pop();
            }
            stack.push(number);
        }
        System.out.println(stack);
    }


    public static void main(String[] args) {
        int[] numbers = {4, 2, 5, 1, 3};
        int[] numbers2 = {3, 1, 5, 2, 4};
        increasing(numbers); // [1, 3]
        increasing(numbers2); // [1, 2, 4]
        decreasing(numbers); //  [1, 3]
        decreasing(numbers2); // [5, 4]
    }

}
