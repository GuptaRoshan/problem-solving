package alogorithm.dp;


public class BoundedKnapsack {

    /**
     * Live Example :
     * <p>
     * Inventory Management for a Retailer
     * <p>
     * Imagine you're a manager at a retail store, and you need to decide which items to stock in your inventory.
     * Each item has a different value (profit) and weight (space it occupies in the storage), and there's a limited supply of each item.
     * <p>
     * <p>
     * Problem Statement :
     * <p>
     * You have a limited storage capacity, and you want to maximize the total profit by choosing which items to stock in your inventory.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * Each item has a certain profit associated with it.
     * Each item also has a specific weight.
     * There's a limited supply (count) of each item available.
     * The storage capacity of your inventory is limited.
     * <p>
     * <p>
     * Objective:
     * <p>
     * Maximize the total profit while ensuring the total weight of the selected items doesn't exceed the storage capacity,
     * and considering the limited supply of each item.
     * <p>
     * <p>
     * Example:
     * <p>
     * Let's say you have the following items available:
     * <p>
     * Item 1: Profit = $60, Weight = 10kg, Count = 2
     * <p>
     * Item 2: Profit = $100, Weight = 20kg, Count = 3
     * <p>
     * Item 3: Profit = $120, Weight = 30kg, Count = 1
     * <p>
     * And your storage capacity is 50kg.
     * <p>
     * <p>
     * Using the bounded knapsack algorithm, you can determine which items to stock in your inventory to maximize the total profit within the given constraints.
     * <p>
     * <p>
     * <p>
     * The bounded knapsack problem is a variation of the classic knapsack problem where each item has a limited number of copies available.
     * The goal is to maximize the total value of items selected while ensuring the total weight does not exceed the capacity of the knapsack.
     *
     * @param values   values of items
     * @param weights  weights of items
     * @param counts   number of copies available for each item
     * @param capacity maximum weight that knapsack can hold
     * @return maximum value that can be obtained
     */
    public static int knapsack(int[] values, int[] weights, int[] counts, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                // For each item, consider the possibility of taking 0 to 'count' copies
                for (int k = 0; k <= counts[i - 1]; k++) {
                    if (k * weights[i - 1] <= j) {
                        // Update the maximum value for the current capacity
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weights[i - 1]] + k * values[i - 1]);
                    }
                }
            }
        }
        return dp[n][capacity];
    }


    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int[] counts = {2, 3, 1}; // Number of copies available for each item
        int capacity = 50;
        // output : 260
        System.out.println("Maximum value that can be obtained: " + knapsack(values, weights, counts, capacity));
    }

}


