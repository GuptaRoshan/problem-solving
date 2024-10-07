package alogorithm.searching;

public class BinarySearch {


    // At last low, high and mid become 0
    public static int naiveSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result = - 1;

        while (low <= high) {
           int mid = low + (high - low) / 2;
           if(target <= nums[mid]){
               result = nums[mid];
               high = mid - 1;
           }else {
               low = mid + 1;
           }
        }

        return result;
    }


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


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(naiveSearch(nums, 1));
    }

}
