package neetcode150.twoPointers;

import java.util.Arrays;

public class TwoSum2_167 {

    /**
     * Two pointers
     *
     * @param numbers sorted in non-decreasing order
     * @param target  an integer
     * @return indices of the two numbers such that they add up to target
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] result = new int[2];

        while (left < right) {
            int sumOfTwo = numbers[left] + numbers[right];
            if (sumOfTwo == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            if (sumOfTwo < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    /**
     * Binary search
     *
     * @param numbers sorted in non-decreasing order
     * @param target  an integer
     * @return indices of the two numbers such that they add up to target
     */
    public static int[] twoSumBinarySearch(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            int tmp = target - numbers[i];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] == tmp) {
                    result[0] = i + 1;
                    result[1] = mid + 1;
                    return result;
                } else if (numbers[mid] < tmp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }


}
