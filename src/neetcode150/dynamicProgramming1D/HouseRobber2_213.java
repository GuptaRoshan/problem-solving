package neetcode150.dynamicProgramming1D;

public class HouseRobber2_213 {

    public static int helper(int[] nums) {
        int n = nums.length + 1;
        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }

    /**
     * Bottom-up dynamic programming (Memoization)
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * dp[i] = max(dp[i - 2] + nums[i - 1], dp[i - 1])
     * dp[0] = 0
     * dp[1] = nums[0]
     *
     * @param nums input array
     * @return maximum amount of money you can rob tonight without alerting the police
     */
    public static int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int val0 = nums[0];
        nums[0] = 0;
        int max1 = helper(nums);
        nums[0] = val0;
        nums[nums.length - 1] = 0;
        int max2 = helper(nums);
        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(rob(nums)); //3
    }

}
