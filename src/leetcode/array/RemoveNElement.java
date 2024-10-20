package leetcode.array;

public class RemoveNElement {


    // https://leetcode.com/problems/remove-element/description/
    // Similar problems  : https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
    // j: The fast pointer scans through the entire array starting from the first element
    // i: The slow pointer tracks the position where the next valid (non-val) element should be written.
    public static int removeElement(int[] nums, int val) {

        int i = 0;
        int j = 0;

        while (j < nums.length) {

            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }

            j++;
        }

        return i;

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int val = 4;
        System.out.println(removeElement(nums, val));
    }
}
