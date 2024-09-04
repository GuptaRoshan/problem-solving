package neetcode150.dynamicProgramming1D;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum_416 {

    static Boolean[][] memo;

    // Approach 1: Done using subset sum problem
    private static boolean subsetSum(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        // If sum is odd, then we can't divide the array into two equal halves
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        Set<Integer> originalSet = new HashSet<>();
        originalSet.add(0);

        for (int num : nums) {
            Set<Integer> newSet = new HashSet<>();
            for (int value : originalSet) {
                newSet.add(value + num);
            }
            originalSet.addAll(newSet);
        }
        return originalSet.contains(target);
    }


    // Approach 2: Done using 0/1 knapsack
    private static boolean knapsack01(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        // If sum is odd, then we can't divide the array into two equal halves
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        int n = nums.length;
        boolean[] dp = new boolean[target + 1];

        Arrays.fill(dp, false);

        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }

        return dp[target];
    }


    // Approach 3: DP  using memoization
    private static boolean memoization(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int i : nums) sum += i;

        if (sum % 2 != 0) return false;

        sum /= 2;

        memo = new Boolean[n + 1][sum + 1];

        return helper(nums, 0, sum, memo);
    }


    private static boolean helper(int[] nums, int pos, int sum, Boolean[][] memo) {
        // Base case if sum is 0, then we have found the subset
        if (sum == 0) return true;

            // Base case if we have reached the end of the array or sum is less than 0
        else if (pos >= nums.length || sum < 0) return false;

        // If the value is already calculated, then return the value
        if (memo[pos][sum] != null) return memo[pos][sum];

        // If the value is not calculated, then calculate the value and store it in the memo
        memo[pos][sum] = helper(nums, pos + 1, sum - nums[pos], memo) || helper(nums, pos + 1, sum, memo);

        return memo[pos][sum];
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(subsetSum(nums));
        System.out.println(knapsack01(nums));
        System.out.println(memoization(nums));
    }

}
