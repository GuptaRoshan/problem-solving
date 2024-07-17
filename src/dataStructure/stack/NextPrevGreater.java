package dataStructure.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextPrevGreater {

    public static int[] findNextGreaterIndexes(int[] arr) {
        // Initialize an empty stack
        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[arr.length];
        Arrays.fill(nextGreater, -1);

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int stackTop = stack.pop();
                nextGreater[stackTop] = i;
            }
            stack.push(i);
        }
        return nextGreater;
    }

    public static int[] findPreviousGreaterIndexes(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] previousGreater = new int[arr.length];
        Arrays.fill(previousGreater, -1);

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                previousGreater[i] = stack.peek();
            }
            stack.push(i);
        }
        return previousGreater;
    }

    public static int[][] findNextAndPreviousGreaterIndexes(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] previousGreater = new int[arr.length];
        int[] nextGreater = new int[arr.length];
        Arrays.fill(previousGreater, -1);
        Arrays.fill(nextGreater, -1);

        // Iterate through all the elements of the array
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                int stackTop = stack.pop();
                nextGreater[stackTop] = i;
            }

            if (!stack.isEmpty()) {
                previousGreater[i] = stack.peek();
            }

            stack.push(i);
        }
        return new int[][]{previousGreater, nextGreater};
    }

    public static void main(String[] args) {
        int[] arr = {13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        System.out.println("Next Greater: " + Arrays.toString(findNextGreaterIndexes(arr)));
        System.out.println("Previous Greater: " + Arrays.toString(findPreviousGreaterIndexes(arr)));
        System.out.println("Next and Previous Greater: " + Arrays.deepToString(findNextAndPreviousGreaterIndexes(arr)));
    }
}
