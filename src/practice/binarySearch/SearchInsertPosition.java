package practice.binarySearch;

public class SearchInsertPosition {

    // Round Down no comparison
    // https://leetcode.com/problems/search-insert-position/description/
    public static int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length; // the only difference is we consider full list size here

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target <= nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }

}
