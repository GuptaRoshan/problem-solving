package practice.binarySearch;

import java.util.Arrays;

public class MakeBouquets {

    public static int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;

        int left = 1;
        int right = Arrays.stream(bloomDay).max().getAsInt();

        // Modified binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!canMake(bloomDay, m, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;
        for (int bloom : bloomDay) {
            // Adjacent flowers
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
            if (bouquets >= m) return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }
}
