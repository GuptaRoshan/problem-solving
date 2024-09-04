package neetcode150.greedy;

public class JumpGame2_45 {

    public static int jump(int[] nums) {
        int reachable = 0;
        int jumps = 0;
        int reached = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // Reachable is the maximum index that can be reached
            reachable = Math.max(reachable, i + nums[i]);
            if (i == reached) {
                jumps++;
                reached = reachable;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
