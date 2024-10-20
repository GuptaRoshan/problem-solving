package leetcode.array;

public class LongestContinuousIncreasingSubsequence {


    // https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
    // Can be done using DP and count variable

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;

        int max = 1;
        int count = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j - 1] < nums[j]) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 1;
            }

        }

        return max;
    }


    public static int findLengthOfLCISDP(int[] nums) {

        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;

        for (int j = 1; j < nums.length; j++) {

            if (nums[j - 1] < nums[j]) {
                dp[j] = dp[j - 1] + 1;
            } else {
                dp[j] = 1;
            }

            max = Math.max(max, dp[j]);

        }

        return max;
    }

    public static void main(String[] args) {
        int[] num = {1,3,5,4,7};
       // num = new int[]{2, 2, 2};
        System.out.println(findLengthOfLCIS(num));
    }
}
