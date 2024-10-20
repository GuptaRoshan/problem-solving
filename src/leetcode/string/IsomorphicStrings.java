package leetcode.string;

import java.util.HashMap;

public class IsomorphicStrings {

    // https://leetcode.com/problems/isomorphic-strings/description/
    // Can be solved using map, frequency count
    public static boolean isIsomorphic(String s, String t) {
        int[] freqMapForSrc = new int[256];
        int[] freqMapForTarget = new int[256];

        for (int i = 0; i < s.length(); i++) {

            if (freqMapForSrc[s.charAt(i)] != freqMapForTarget[t.charAt(i)]) {
                return false;
            }

            freqMapForSrc[s.charAt(i)] = i + 1;
            freqMapForTarget[t.charAt(i)] = i + 1;
        }

        return true;
    }

    public static boolean isIsomorphicUsingMap(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (!map.containsKey(a)) {
                if (map.containsValue(b)) return false;
                map.put(a, b);
            } else {
                if (!map.get(a).equals(b)) return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        System.out.println(isIsomorphic(s, t));
        System.out.println(isIsomorphicUsingMap(s, t));
    }

}

