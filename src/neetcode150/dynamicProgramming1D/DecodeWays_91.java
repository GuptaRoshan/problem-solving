package neetcode150.dynamicProgramming1D;

public class DecodeWays_91 {

    /**
     * A message containing letters from A-Z can be encoded into numbers using the following mapping:
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * Given a string s containing digits, return the number of ways to decode it.
     *
     * @param s string containing digits
     * @return the number of ways to decode it
     */
    public static int numDecodings(String s) {

        if (s == null || s.isEmpty()) return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int firstDigit = Integer.parseInt(s.substring(i - 1, i));
            int secondDigit = Integer.parseInt(s.substring(i - 2, i));
            if (firstDigit >= 1 && firstDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            if (secondDigit >= 10 && secondDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }

}
