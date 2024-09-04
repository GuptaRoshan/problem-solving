package neetcode150.slidingWindow;

public class BuySellStock_121 {

    /**
     * @param prices an array where prices[i] is the price of a given stock on the ith day
     * @return the maximum profit you can achieve from this transaction.
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int val : prices) {
            min = Math.min(min, val);
            maxProfit = Math.max(maxProfit, val - min);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
