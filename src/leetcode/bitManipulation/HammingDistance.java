package leetcode.bitManipulation;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;

        for (int i = 0; i < 32; i++) {
            distance += (xor >> i) & 1;
        }

        return distance;
    }
}
