package practice.array;

public class MaxConsecutiveOnes {

    // https://leetcode.com/problems/max-consecutive-ones/description/
    // Used two pointers
    public static int findMaxConsecutiveOnes(int[] nums) {

        int i = 0;
        int j = 0;

        int count = 0;

        while (j < nums.length) {

            if (nums[i] == nums[j] && nums[j] == 1) {
                j++;
            } else {
                i = j + 1;
                j = j + 1;
            }

            count = Math.max(count, j - i);
        }

        return count;
    }

    public static int findMaxConsecutiveOnesOptimized(int[] nums) {
        int maxHere = 0;
        int max = 0;

        for(int num : nums){
           max = Math.max(max,  maxHere = num == 0 ? 0 : maxHere + 1);
        }

        return max;
    }



    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnesOptimized(nums));
    }


}
