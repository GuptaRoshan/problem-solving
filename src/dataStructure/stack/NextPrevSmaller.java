package dataStructure.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextPrevSmaller {

    //---------------------------------Next Smaller Element---------------------------------------//
    public static int[] findNextSmallerIndexes(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nextSmaller = new int[arr.length];
        Arrays.fill(nextSmaller, -1);

        for (int i = 0; i < arr.length; i++) {
            // arr[i] is smaller than stack.peek(), means we have found next smaller element for stack.peek()
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int stackTop = stack.pop();
                nextSmaller[stackTop] = i;
            }
            stack.push(i);
        }
        return nextSmaller;
    }

    //---------------------------------Previous Smaller Element---------------------------------------//
    public static int[] findPreviousSmallerIndexes(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] previousSmaller = new int[arr.length];
        Arrays.fill(previousSmaller, -1);

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // we have found the previous smaller element for i, which is in stack
            if (!stack.isEmpty()) {
                previousSmaller[i] = stack.peek();
            }
            stack.push(i);
        }
        return previousSmaller;
    }

    //---------------------------------Next and Previous Smaller Element---------------------------------------//
    public static int[][] findNextAndPreviousSmallerIndexes(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] previousSmaller = new int[arr.length];
        int[] nextSmaller = new int[arr.length];
        Arrays.fill(previousSmaller, -1);
        Arrays.fill(nextSmaller, -1);

        // Iterate through all the elements of the array
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int stackTop = stack.pop();
                nextSmaller[stackTop] = i;
            }

            if (!stack.isEmpty()) {
                previousSmaller[i] = stack.peek();
            }

            stack.push(i);
        }
        return new int[][]{previousSmaller, nextSmaller};
    }

    public static void main(String[] args) {
        int[] arr = {13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        System.out.println("Next Smaller: " + Arrays.toString(findNextSmallerIndexes(arr)));
        System.out.println("Previous Smaller: " + Arrays.toString(findPreviousSmallerIndexes(arr)));
        System.out.println("Next and Previous Smaller: " + Arrays.deepToString(findNextAndPreviousSmallerIndexes(arr)));
    }
}
