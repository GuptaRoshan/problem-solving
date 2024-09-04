package neetcode150.twoPointers;

public class ContainerWithMostWater_11 {

    /**
     * Index i contains the width of the container and the value at index i contains the height of the container
     *
     * @param height an array of non-negative integers
     * @return the maximum area of the container
     */
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;

        while (start < end) {
            // Calculates the width
            int w = end - start;
            // Calculates the height
            int h = Math.min(height[start], height[end]);
            int area = w * h;
            max = Math.max(max, area);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
