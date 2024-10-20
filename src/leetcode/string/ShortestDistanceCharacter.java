package leetcode.string;

import java.util.Arrays;
import java.util.TreeSet;

public class ShortestDistanceCharacter {


    // https://leetcode.com/problems/shortest-distance-to-a-character/description/
    // Can be done is using left pass and right pass, with distributing
    public static int[] shortestToChar(String s, char c) {

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                treeSet.add(i);
            }
        }

        int[] result = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int min;

            int ceilMin = Integer.MAX_VALUE;
            int floorMin = Integer.MAX_VALUE;

            if (treeSet.ceiling(i) != null) {
                ceilMin = treeSet.ceiling(i) - i;
            }

            if (treeSet.floor(i) != null) {
                floorMin = i - treeSet.floor(i);
            }

            min = Math.min(ceilMin, floorMin);

            result[i] = min;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';

        System.out.println(Arrays.toString(shortestToChar(s, c)));
    }
}
