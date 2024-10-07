package practice.array;

import java.util.Arrays;

public class ThirdMax {

    public static int thirdMax(int[] nums) {
        // Sorting the array in ascending order
        Arrays.sort(nums);

        // Reversing the array for descending order
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }

        int ans = nums[0];
        int count = 1;
        int prev = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prev = ans;
            max = Math.max(prev, max);
            if (nums[i] == prev) continue;

            ans = nums[i];
            count++;

            if (count == 3) break;
        }

        return count == 3 ? ans : max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2};
    }

}
