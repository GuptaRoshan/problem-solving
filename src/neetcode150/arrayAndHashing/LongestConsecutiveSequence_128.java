package neetcode150.arrayAndHashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {

    /**
     * Longest Consecutive Sequence
     *
     * @param nums array of integers
     * @return length of the longest consecutive elements sequence
     */

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;

        for (int x : nums) {
            set.add(x);
        }

        for (int y : nums) {
            int count = 1;

            int temp = y;
            while (set.contains(--temp)) {
                count++;
                set.remove(temp);
            }

            temp = y;
            while (set.contains(++temp)) {
                count++;
                set.remove(temp);
            }

            result = Math.max(result, count);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.print(longestConsecutive(nums));
    }
    
}
