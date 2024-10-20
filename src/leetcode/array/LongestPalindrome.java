package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

    // count pairs to make valid palindrome
    // https://leetcode.com/problems/longest-palindrome/description/
    public static int longestPalindrome(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (set.remove(s.charAt(i))) {
                count += 1;
            } else {
                set.add(s.charAt(i));
            }
        }

        return count * 2 + (set.isEmpty() ? 0 : 1);
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

}
