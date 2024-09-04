package neetcode150.binarySearch;

public class KokoEatingBananas_875 {

    // Finding minimum speed K to eat all bananas in h hours
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        // Constraints banana size: 1 <= piles[i] <= 1_000_000_000
        // We can also take high as max value in piles
        int right = 1_000_000_000;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static boolean canEatAll(int[] piles, int speed, int h) {
        long hours = 0;
        for (int pile : piles) {
            int time = pile / speed;
            hours = hours + time; // Actual Speed if koko can eat in time, if its 0 then she can eat in time
            if (pile % speed != 0) hours++; // If there is some remaining then add 1 more hour
        }
        return hours <= h;
    }


    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h)); // 4

        piles = new int[]{30, 11, 23, 4, 20};
        h = 5;
        System.out.println(minEatingSpeed(piles, h)); // 30
    }

}
