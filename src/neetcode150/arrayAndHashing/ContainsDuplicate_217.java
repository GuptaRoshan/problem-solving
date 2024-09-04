package neetcode150.arrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate_217 {

    /**
     * Using brute force to check if there are any duplicates in the array.
     *
     * @param nums an integer array
     * @return true if any value appears at least twice in the array, and return false if every element is distinct
     */
    public static boolean containsDuplicateBruteForce(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }


    /**
     * Using set to store the elements of the array. If the set already contains the element, return true.
     *
     * @param nums an integer array
     * @return true if any value appears at least twice in the array, and return false if every element is distinct
     */
    public static boolean containsDuplicateSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int val : nums) {
            if (set.contains(val)) {
                return true;
            }
            set.add(val);
        }
        return false;
    }


    /**
     * Sort the array and check if there are any duplicates by comparing the adjacent elements.
     *
     * @param nums an integer array
     * @return true if any value appears at least twice in the array, and return false if every element is distinct
     */
    public static boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }


    /**
     * Using map to check the duplicates
     *
     * @param nums an integer array
     * @return true if any value appears at least twice in the array, and return false if every element is distinct
     */
    public static boolean containsDuplicateMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                return true;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(containsDuplicateSet(nums1));
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(containsDuplicateBruteForce(nums2));
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicateMap(nums3));
        int[] nums4 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicateSort(nums4));
    }
}
