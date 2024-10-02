package alogorithm.searching;

public class BinarySearch {


    // At last low, high and mid become 0
    public static int naiveSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // Causes integer overflow
            int mid = low + high / 2;

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



    // Round down no Comparison (eliminates integer overflow)
    // If elements are even it selects a leftmost element, mid = low + (high - low) / 2;
    // At last low, high converges to 0, and mid will have the leftmost element
    public static int searchRoundDownNoComparison(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target <= nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return nums[low] == target ? low : -1; // low == high
    }


    // Round up no Comparison (eliminates integer overflow)
    // If elements are even it selects a rightmost element, low + (high - low + 1) / 2
    public static int searchRoundUpNoComparison(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (target >= nums[mid]) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return nums[low] == target ? low : -1;  // low == high
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(searchRoundDownNoComparison(nums, 1));
    }

}
