package practice.array;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    // https://leetcode.com/problems/longest-harmonious-subsequence/description/
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;

        for (int num : nums) {
            if (count.containsKey(num) && count.containsKey(num + 1)) {
                maxLen = Math.max(maxLen, count.get(num) + count.get(num + 1));
            }
        }

        return maxLen;
    }


    public static void main(String[] args){
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }


}
