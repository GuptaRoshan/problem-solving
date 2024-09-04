package neetcode150.greedy;

import java.util.Arrays;

public class MergeTriplets_1899 {

    public static boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] result = new int[3];
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                result = new int[]{Math.max(triplet[0], result[0]), Math.max(triplet[1], result[1]), Math.max(triplet[2], result[2])};
            }
        }
        return Arrays.equals(result, target);
    }

    public static void main(String[] args) {
        int[][] triplets = {{2,5,3},{1,8,4},{1,7,5}};
        int[] target = {2,7,5};
        System.out.println(mergeTriplets(triplets, target));
    }

}
