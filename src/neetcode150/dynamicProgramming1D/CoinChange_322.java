package neetcode150.dynamicProgramming1D;

import java.util.Arrays;

public class CoinChange_322 {

    /**
     * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
     *
     * @param coins  array of coins
     * @param amount amount
     * @return minimum number of coins that you need to make up that amount
     */
    public static int coinChange(int[] coins, int amount) {
        int maxAmount = amount + 1;
        int[] dp = new int[maxAmount];
        Arrays.fill(dp, maxAmount);
        dp[0] = 0;

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coin : coins) {
                if (coin <= currentAmount) {
                    dp[currentAmount] = Math.min(dp[currentAmount], dp[currentAmount - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));

        coins = new int[]{2};
        amount = 3;
        System.out.println(coinChange(coins, amount));
    }

}
