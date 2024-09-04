package neetcode150.arrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {

    /**
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     *
     * @param s a string
     * @param t a string
     * @return true if t is an anagram of s, and false otherwise
     */
    public static boolean isAnagramHashTable(String s, String t) {
        int[] count = new int[26];

        // Count the frequency of characters in string s
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Decrement the frequency of characters in string t
        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }

        // Check if any character has non-zero frequency
        for (int value : count) {
            if (value != 0) return false;
        }

        return true;
    }

    /**
     * Sort the characters of the strings and compare them.
     *
     * @param s a string
     * @param t a string
     * @return true if t is an anagram of s, and false otherwise
     */
    public static boolean isAnagramSorting(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    /**
     * Using a map to store the frequency of characters in string s and decrement the frequency of characters in string t.
     *
     * @param s a string
     * @param t a string
     * @return true if t is an anagram of s, and false otherwise
     */
    public static boolean isAnagramMap(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();

        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }

        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagramHashTable(s, t));
        System.out.println(isAnagramSorting(s, t));
        System.out.println(isAnagramMap(s, t));
    }
}
