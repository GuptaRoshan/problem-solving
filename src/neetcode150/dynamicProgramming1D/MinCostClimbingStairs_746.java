package neetcode150.dynamicProgramming1D;

public class MinCostClimbingStairs_746 {

    /**
     * Min Cost Climbing Stairs
     *
     * @param cost cost of each step
     * @return minimum cost to reach the top of the floor
     */
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        //return Math.min(memoization(cost, dp, n - 1), memoization(cost, dp, n - 2));
        return tabulation(cost,dp, n);
    }


    /**
     * Min Cost Climbing Stairs using memoization
     *
     * @param cost cost of each step
     * @param dp   dynamic programming array
     * @param n    number of stairs
     * @return minimum cost to reach the top of the floor
     */
    public static int memoization(int[] cost, int[] dp, int n) {
        if (n < 0) return 0;

        if (n < 2) return cost[n];

        if (dp[n] != 0) return dp[n];

        dp[n] = cost[n] + Math.min(memoization(cost, dp, n - 1), memoization(cost, dp, n - 2));

        return dp[n];
    }

    /**
     * Min Cost Climbing Stairs using tabulation
     *
     * @param cost cost of each step
     * @param dp   dynamic programming array
     * @param n    number of stairs
     * @return minimum cost to reach the top of the floor
     */
    public static int tabulation(int[] cost, int[] dp, int n) {
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                dp[i] = cost[i];
            } else {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost)); // 15

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost2)); // 6
    }

}
