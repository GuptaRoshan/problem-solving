package neetcode150.slidingWindow;

import java.util.Arrays;

public class SlidingWindowMaximum_239 {

    public static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        int numOfWindow = n - k + 1; // Number of windows
        int[] result = new int[numOfWindow]; // Number of windows

        for (int start = 0; start < numOfWindow; start++) {
            int end = start + k - 1; // End index of the window
            System.out.println("start index of window: " + start + " end index of window: " + end);

            int maxVal = nums[start];

            // Calculate the maximum value in the window
            for (int i = start + 1; i <= end; i++) {
                if (nums[i] > maxVal) {
                    maxVal = nums[i];
                }
            }

            result[start] = maxVal;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindowBruteForce(nums, k)));
    }
}
