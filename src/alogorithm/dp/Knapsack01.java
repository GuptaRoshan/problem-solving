package alogorithm.dp;

public class Knapsack01 {


    /**
     * 0/1 Knapsack Problem
     * <p>
     * Given weights and values of n items, put these items in a knapsack of
     * capacity W to get the maximum total value in the knapsack. In the 0/1
     * knapsack, an item can be used only once.
     * <p>
     * Time Complexity: O(n * capacity)
     * Space Complexity: O(n * capacity)
     *
     * @param values   - values of items
     * @param weights  - weights of items
     * @param capacity - maximum weight that knapsack can hold
     * @return maximum value that can be obtained
     */
    public static int knapsack01(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= capacity; j++) {

                if (i == 0 || j == 0) dp[i][j] = 0;

                else if (weights[i - 1] <= j) {
                    //  dp[i - 1][j]: This represents the maximum value that can be obtained without including item i
                    //  values[i - 1]: Includes the current item
                    //  dp[i - 1][j - weights[i - 1]]: Find the cost of remaining capacity by considering the previous items (i - 1)

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[n][capacity];
    }

    public static int knapsack01Optimized(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            for (int c = capacity; c > 0; c--) {

                if(weights[i] <= c){
                    dp[c] = Math.max(dp[c], values[i] + dp[c - weights[i]]);
                }

            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        // 100 + 120 Select 20 and 30 only once which amounts to 50 and get maximum value 220
        System.out.println("Maximum value that can be obtained: " + knapsack01Optimized(values, weights, capacity));
        System.out.println("Maximum value that can be obtained: " + knapsack01(values, weights, capacity));
    }

}
