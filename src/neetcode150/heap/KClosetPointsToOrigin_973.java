package neetcode150.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosetPointsToOrigin_973 {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((left, right) -> getDistance(right) - getDistance(left));

        // Time: O(nlogK), Space: O(K)
        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > K) heap.poll();
        }

        int[][] result = new int[K][2];
        while (K > 0) {
            K--;
            result[K] = heap.poll();
        }

        return result;
    }

    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        KClosetPointsToOrigin_973 kClosetPointsToOrigin973 = new KClosetPointsToOrigin_973();
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        int K = 1;
        int[][] result = kClosetPointsToOrigin973.kClosest(points, K);

        System.out.println(Arrays.deepToString(result));
    }

}
