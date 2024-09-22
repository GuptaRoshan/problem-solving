package neetcode150.dynamicProgramming2D;

public class BestTimeToBuySellStock_309 {

    // State Transition DP or Multi-State DP
    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int[] hold = new int[n];      // Max profit while holding a stock
        int[] sell = new int[n];      // Max profit after selling a stock
        int[] cooldown = new int[n];  // Max profit during cooldown

        // Initial conditions
        hold[0] = -prices[0]; // Buying on the first day
        sell[0] = 0;          // Cannot sell on the first day
        cooldown[0] = 0;      // No cooldown profit on the first day

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = hold[i - 1] + prices[i];
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        }

        // The answer is the max profit on the last day, either sold or in cooldown
        return Math.max(sell[n - 1], cooldown[n - 1]);
    }

    public static void main(String[] args) {
        int[] prices1 = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices1)); // Output: 3

        int[] prices2 = {1};
        System.out.println(maxProfit(prices2)); // Output: 0
    }

}
