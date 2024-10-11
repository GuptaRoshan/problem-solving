package practice;

import java.util.Arrays;

public class Test {

    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int expectedSum =  n * (n + 1) / 2;

        int totalSum = nums[0];
        int duplicate = -1;

        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];

            if (nums[i - 1] == nums[i]) {
                duplicate = nums[i];
            }

        }

        int missing = expectedSum - (totalSum - duplicate);
        return new int[]{duplicate, missing};
    }

    public static void main(String[] args) {
        int[] nums = {1,5,3,2,2,7,6,4,8,9};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

}


