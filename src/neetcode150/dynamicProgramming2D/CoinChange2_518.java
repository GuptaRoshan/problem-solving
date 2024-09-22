package neetcode150.dynamicProgramming2D;

public class CoinChange2_518 {


    /**
     * @return number of ways to make sum s using repeated coins
     * Unbounded knapsack
     */
    public static int coinrep(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] += dp[i - coin];
        return dp[amount];
    }

    /**
     * @return number of ways to make sum s using non-repeated coins
     * <p>
     * 01 Knapsack
     */
    public static int coinnonrep(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins)
            for (int i = amount; i >= coin; i--)
                dp[i] += dp[i - coin];
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        System.out.println(coinrep(amount, coins));
        System.out.println(coinnonrep(amount, coins));
    }
}


