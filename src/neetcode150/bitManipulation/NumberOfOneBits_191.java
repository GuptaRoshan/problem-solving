package neetcode150.bitManipulation;

public class NumberOfOneBits_191 {

    /**
     * The idea is to remove the rightmost one from n in each iteration
     * and increment the count.
     * <p>
     * n & (n - 1) will remove the rightmost 1 from n.
     * n = 1010
     * n - 1 = 1001
     * n & (n - 1) = 1000
     * <p>
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @param n input integer n
     * @return Number of bits in n
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            // n & (n - 1) will remove the rightmost 1 from n
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    /**
     * The idea is to check each bit of n.
     * <p>
     * n & 1 will check the rightmost bit of n.
     * n = 1010
     * n & 1 = 0
     * <p>
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @param n input integer n
     * @return number of bits in n
     */

    @SuppressWarnings("unused")
    public static int hammingWeight2(int n) {
        int ones = 0;
        while (n != 0) {
            // Either n is 0 or n is 1
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 16; i++) {
            System.out.println(Integer.toBinaryString(i) + " -> " + hammingWeight(i));
        }
    }
}
