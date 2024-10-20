package leetcode.bitManipulation;

public class AlternatingBits {

    // Check whether the number has alternating bits or not
    // https://leetcode.com/problems/binary-number-with-alternating-bits/description/

    boolean hasAlternatingBits2(int n) {
        // n = 170
        /*
        n =         1 0 1 0 1 0 1 0
        n >> 1      0 1 0 1 0 1 0 1
        n ^ n>>1    1 1 1 1 1 1 1 1
        n           1 1 1 1 1 1 1 1
        n + 1     1 0 0 0 0 0 0 0 0
        n & (n+1)   0 0 0 0 0 0 0 0
        */

        n = n ^ (n>>1);
        return (n & n+1) == 0;
    }
}
