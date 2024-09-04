package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {


    /**
     * Bitwise approach.
     * The idea is to generate all possible subsets using bitwise.
     * For example, for an array [1, 2, 3], the total number of possible subsets is 2^3 = 8 subsets.
     * The subsets are:
     * 000 -> []
     * 001 -> [3]
     * 010 -> [2]
     * 011 -> [2, 3]
     * 100 -> [1]
     * 101 -> [1, 3]
     * 110 -> [1, 2]
     * 111 -> [1, 2, 3]
     *
     * @param nums   input array
     * @param result result list
     */
    public static void bitwise(int[] nums, List<List<Integer>> result) {
        int n = nums.length;
        int totalSubset = 1 << n; // 1 * 2^n

        for (int i = 0; i < totalSubset; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                System.out.println((i >> j) & 1);
                if (((i >> j) & 1) == 1) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
    }


    /**
     * Backtracking approach.
     * The idea is to generate all possible subsets using backtracking.
     *
     * @param nums   input array
     * @param list   temporary list
     * @param result result list
     * @param start  start index
     */
    public static void backtrack(int[] nums, List<Integer> list, List<List<Integer>> result, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, list, result, i + 1);
            list.removeLast();
        }
    }


    /**
     * Iterative approach.
     * Using [1, 2, 3] as an example, the iterative process is like:
     * Initially, one empty subset [[]]
     * Adding 1 to []: [[], [1]];
     * Adding 2 to [] and [1]: [[], [1], [2], [1, 2]];
     * Adding 3 to [], [1], [2] and [1, 2]: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]].
     *
     * @param nums   input array
     * @param result result list
     */
    public static void iterative(int[] nums, List<List<Integer>> result) {
        result.add(new ArrayList<>());
        for (int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
    }

    /**
     * Approach: Backtracking (Recursion) - Picking and Not Picking
     * 1. We either pick the element and move ahead (increment the index) or,
     * 2. We don't pick the element and move ahead
     *
     * @param nums   the input array
     * @param i      the current index
     * @param temp   the current subset
     * @param result the result list
     */
    public static void picking(int[] nums, List<Integer> temp, List<List<Integer>> result, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        picking(nums, temp, result, i + 1); // pick the current element
        temp.removeLast(); // removed the current picked element
        picking(nums, temp, result, i + 1); // do not pick the current element
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        //backtrack(nums, new ArrayList<>(), result, 0);
        //bitwise(nums, result);
        //iterative(nums, result);
        picking(nums, new ArrayList<>(), result, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

}
