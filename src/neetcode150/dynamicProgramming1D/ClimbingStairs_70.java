package neetcode150.dynamicProgramming1D;

public class ClimbingStairs_70 {

    /**
     * Climbing Stairs
     *
     * @param n number of stairs
     * @return number of distinct ways to climb to the top
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return memoization(n, dp);
    }

    /**
     * Climbing Stairs using memoization
     *
     * @param n  number of stairs
     * @param dp dynamic programming array
     * @return number of distinct ways to climb to the top
     */
    public static int memoization(int n, int[] dp) {
        if (n <= 2) return n;

        if (dp[n] != 0) return dp[n];

        dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);

        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(2)); // 2
        System.out.println(climbStairs(3)); // 3
        System.out.println(climbStairs(4)); // 5
        System.out.println(climbStairs(5)); // 8
    }
}
