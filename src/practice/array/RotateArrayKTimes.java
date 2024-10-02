package practice.array;

import java.util.Arrays;


// https://leetcode.com/problems/rotate-array/description/
public class RotateArrayKTimes {

    public static void reverse(int nums[], int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {
        // Ensure k is within array bounds
        k %= nums.length;
        // Reverse entire array
        reverse(nums, 0, nums.length - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining elements
        reverse(nums, k, nums.length - 1);
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 1;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

}
