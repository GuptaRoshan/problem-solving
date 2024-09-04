package neetcode150.greedy;

public class JumpGame_55 {

    public static boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            // Reachable is the maximum index that can be reached
            reachable = Math.max(reachable, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0};
        System.out.println(canJump(nums));
        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }
}
