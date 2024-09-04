package neetcode150.twoPointers;

public class TrappingRainWater_42 {

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
     *
     * @param height an array of non-negative integers
     * @return the total amount of water that can be trapped
     */
    public static int trap(int[] height) {

        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int totalCount = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // leftMax < rightMax: It means you can trap water in the left section
            // leftMax - height[left]: No. of units can be trapped
            if (leftMax < rightMax) {
                totalCount += (leftMax - height[left]);
                left++;

            } else {
                totalCount += (rightMax - height[right]);
                right--;
            }
        }

        return totalCount;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

}
