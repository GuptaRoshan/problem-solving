package neetcode150.dynamicProgramming1D;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {

    /**
     * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     *
     * @param s        the string
     * @param wordDict the dictionary of words
     * @return true if s can be segmented into a space-separated sequence of one or more dictionary words
     * Recursive solution: <a href="https://leetcode.com/problems/word-break/solutions/169383/solved-the-time-complexity-of-the-brute-force-method-should-be-o-2-n-and-prove-it-below/"> Link </a>
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }

}
