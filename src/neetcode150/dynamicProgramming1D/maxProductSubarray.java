package neetcode150.dynamicProgramming1D;

public class maxProductSubarray {

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        double maxLeft = 1;
        double maxRight = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {

            //if any of l or r become 0 then update it to 1
            maxLeft = maxLeft == 0 ? 1 : maxLeft;
            maxRight = maxRight == 0 ? 1 : maxRight;

            maxLeft *= nums[i]; //prefix product
            maxRight *= nums[n - 1 - i]; //suffix product

            ans = (int) Math.max(ans, Math.max(maxLeft, maxRight));

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, -3, -2, 4};
        System.out.println(maxProduct(nums));
    }
}

