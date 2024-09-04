package neetcode150.greedy;

public class MaximumSubarray_53 {

    // Kadane's algorithm
    public static int maxSubArray_Kandane(int[] nums) {
        int maxSoFar = nums[0];
        int maxEnd = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEnd = Math.max(nums[i], maxEnd + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEnd);
        }

        return maxSoFar;
    }


    // Dynamic programing
    public static int maxSubArray(int[] nums) {
        int n = nums.length + 1;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = nums[0];
        int max = dp[1];

        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(nums[i], dp[i] + nums[i]);
            max = Math.max(max, dp[i + 1]);
        }

        return max;
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray_Kandane(nums));
        System.out.println(maxSubArray(nums));
    }
}
