package neetcode150.bitManipulation;

import java.util.Arrays;

public class CountingBits_338 {

    /**
     * Given a non-negative integer number num. For every number i in the range 0 ≤ i ≤ num calculate the number of 1's
     *
     * @param num the non-negative integer number
     * @return the number of 1's in their binary representation as an array
     */
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        int offset = 1;
        for (int index = 1; index < num + 1; ++index) {
            if (offset * 2 == index) {
                offset *= 2;
            }
            result[index] = result[index - offset] + 1;
        }
        return result;
    }

    /**
     *
     * @param n the non-negative integer number
     * @return the number of 1's in their binary representation as an array
     */
    public static int[] countBitsDP(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args){
        int n = 5;
        System.out.println(Arrays.toString(countBitsDP(n)));
        System.out.println(Arrays.toString(countBits(n)));
    }
}
