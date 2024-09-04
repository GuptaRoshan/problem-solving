package neetcode150.dynamicProgramming1D;

public class LongestPalindromicSubstring_5 {

    /**
     * @param s input string
     * @return longest palindromic substring
     */
    public static String longestPalindrome(String s) {
        String result = "";
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > result.length()) {
                        result = s.substring(j, i + 1);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
