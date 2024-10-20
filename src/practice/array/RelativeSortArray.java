package practice.array;

import java.util.Arrays;

public class RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counting = new int[1001];

        for (int val : arr1) {
            counting[val]++;
        }

        int index = 0;
        for (int val : arr2) {

            while (counting[val] > 0) {
                arr1[index] = val;
                counting[val]--;
                index++;
            }

        }

        for (int i = 0; i < counting.length; i++) {
            while (counting[i] > 0) {
                arr1[index] = i;
                counting[i]--;
                index++;
            }
        }

        return arr1;
    }


    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}; // [2,2,2,1,4,3,3,9,6,7,19]
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
}
