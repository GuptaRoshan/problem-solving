package practice.binarySearch;

public class FloorCeilInSortedArray {


    // https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
    public static int findFloor(long[] arr, int n, long x) {

        int low = 0;
        int high = arr.length - 1;
        int floorIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                floorIndex = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return floorIndex;
    }

    public static int findCeil(long[] arr, int n, long x) {

        int low = 0;
        int high = arr.length - 1;
        int ceilIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ceilIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return ceilIndex;
    }


    public static void main(String[] args) {
        long[] nums = {1, 2, 8, 10, 11, 12, 19};
        int x = 5;
        int n = 7;
        System.out.println(findFloor(nums, n, x));
        System.out.println(findCeil(nums, n, x));
    }

}
