package dataStructure.searching;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // causes integer overflow
            // int mid = low + high / 2;
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

    public static int searchRecursive(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (target == nums[mid]) {
            return mid;
        }

        if (target > nums[mid]) {
            return searchRecursive(nums, target, mid + 1, high);
        } else {
            return searchRecursive(nums, target, mid - 1, high);
        }
    }

    // round down (eliminates integer overflow)
    public static int searchRoundDown(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // round down (eliminates integer overflow)
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Round up (eliminates integer overflow)
    public static int searchRoundUp(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low + 1) / 2; // round up (eliminates integer overflow)
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    //Round down no Comparison
    public static int searchRoundDownNoComparison(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low < high) { // notice we do not compare element at mid with our target
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) high = mid;
            else low = mid + 1;
        }

		 /* at this point, our search space has shrunk to
		only one element if a current element is the target element
		then return its index else we can safely assume that element was not found*/

        return nums[low] == target ? low : -1; // low == high
    }


    public static int searchRoundUpNoComparison(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low < high) { // notice we do not compare element at mid with our target
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] <= target) low = mid;
            else high = mid - 1;
        }

        /* at this point, our search space has shrunk to
		only one element if a current element is the target element
		then return its index else we can safely assume that element was not found*/

        return nums[low] == target ? low : -1;  // low == high
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(searchRoundDownNoComparison(nums, 3));
    }


}
