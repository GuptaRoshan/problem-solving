package alogorithm.searching;

import java.util.TreeSet;

public class BinarySearch {

    public static int recursiveSearch(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (target == nums[mid]) {
            return mid;
        }

        if (target > nums[mid]) {
            return recursiveSearch(nums, target, mid + 1, high);
        } else {
            return recursiveSearch(nums, target, mid - 1, high);
        }
    }

    public static int naiveSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // Causes integer overflow
            int mid = low + high / 2;

            // round down (eliminates integer overflow)
            // If elements are even it selects leftmost element
            // int mid = low + (high - low) / 2;


            // // round up (eliminates integer overflow)
            // If elements are even it selects rightmost element
            // low + (high - low + 1) / 2

            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


    //Round down no Comparison
    public static int searchRoundDownNoComparison(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target <= nums[mid]) 
               high = mid;
            else 
              low = mid + 1;
        }
        // return low gives insertion point
        return nums[low] == target ? low : -1; // low == high
    }


    public static int searchRoundUpNoComparison(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (target >=  nums[mid]) 
               low = mid;
            else 
               high = mid - 1;
        }

        return nums[low] == target ? low : -1;  // low == high
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(naiveSearch(nums, 3));
    }
    
}
