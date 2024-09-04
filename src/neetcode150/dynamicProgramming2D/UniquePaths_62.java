package neetcode150.dynamicProgramming2D;

public class UniquePaths_62 {

    /**
     * Dynamic programming bottom-up approach
     *
     * @param m number of rows
     * @param n number of columns
     * @return number of unique paths from top left to bottom right
     */
    public int BottomUp(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * Dynamic programming top-down approach
     *
     * @param m number of rows
     * @param n number of columns
     * @return number of unique paths from top left to bottom right
     */
    public int topDown(int m, int n) {
        return topDownHelper(m - 1, n - 1);
    }

    private int topDownHelper(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        } else if (m == 0 || n == 0) {
            return 1;
        } else {
            return topDownHelper(m - 1, n) + topDownHelper(m, n - 1);
        }
    }


    /**
     * Dynamic programming top-down with memoization approach
     *
     * @param m number of rows
     * @param n number of columns
     * @return number of unique paths from top left to bottom right
     */
    public int topDownMemoized(int m, int n) {
        return topDownMemoizedHelper(m - 1, n - 1, new int[n][m]);
    }

    private int topDownMemoizedHelper(int m, int n, int[][] memo) {
        if (m < 0 || n < 0) {
            return 0;
        } else if (m == 0 || n == 0) {
            return 1;
        } else if (memo[n][m] > 0) {
            return memo[n][m];
        } else {
            memo[n][m] = topDownMemoizedHelper(m - 1, n, memo) + topDownMemoizedHelper(m, n - 1, memo);
            return memo[n][m];
        }
    }

    public static void main(String[] args) {
        UniquePaths_62 uniquePaths = new UniquePaths_62();
        System.out.println(uniquePaths.BottomUp(3, 7)); // 28
        System.out.println(uniquePaths.topDown(3, 7)); // 28
        System.out.println(uniquePaths.topDownMemoized(3, 7)); // 28
    }

}
