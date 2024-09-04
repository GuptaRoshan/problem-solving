package neetcode150.bitManipulation;

public class SingleNumber_136 {

    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     *
     * @param nums array of integers
     * @return single number
     */
    public static int singleNumber(int[] nums) {
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i != len; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));
    }

}
