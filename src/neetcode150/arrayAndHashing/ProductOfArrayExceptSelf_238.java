package neetcode150.arrayAndHashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {

    /**
     * Product of Array Except Self
     *
     * @param nums array of integers
     * @return array of integers where each element is the product of all elements of the array except itself
     */
    public static int[] productExceptSelf(int[] nums) {
        // Prefix product
        int p = 1;
        int[] prefix = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = p;
            p = p * nums[i];
        }

        // Suffix product
        p = 1;
        int[] suffix = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix[i] = p;
            p = p * nums[i];
        }

        // Product of prefix and suffix
        int[] product = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            product[i] = prefix[i] * suffix[i];
        }

        return product;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.print(Arrays.toString(productExceptSelf(nums)));
    }

}
