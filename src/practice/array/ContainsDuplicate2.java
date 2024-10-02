package practice.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {

    // https://leetcode.com/problems/contains-duplicate-ii/description/
    // Solve by keeping track of last seen index in a map
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int difference = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                int lastSeenIndex = indexMap.get(nums[i]);
                difference = i - lastSeenIndex;

                if(difference <= k) return true;
            }
            indexMap.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums;
        int k;

        // First case
        nums = new int[]{1, 0, 1, 1};
        k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));

        // Second case
        nums = new int[]{1, 0, 1, 1};
        k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));

        // Third case
        nums = new int[]{1, 2, 3, 1, 2, 3};
        k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
