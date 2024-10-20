package leetcode.array;

public class CheckArraySortedAndRotated {

    // https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/submissions/1399596325/
    public static boolean check(int[] nums) {
        int deviations = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                deviations++;
            }
        }

        return deviations < 2;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(check(nums));
    }
}
