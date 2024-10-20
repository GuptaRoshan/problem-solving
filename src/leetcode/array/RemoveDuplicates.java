package leetcode.array;

public class RemoveDuplicates {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
    // Two pointers, Creating a boundary to separate element
    // j: The fast pointer scans through the array starting from the second element
    // i: The slow pointer tracks the position where the next unique element should be written
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int j = 0; // creates boundary for unique element
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                j = j + 1;
                nums[j] = nums[i];
            }
        }

        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

}
