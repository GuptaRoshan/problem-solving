package alogorithm.sorting;

import java.util.Arrays;

public class CyclicSort {

    // Used to sort number within bounded index range
    // Can be used to find all the duplicate items
    public static void cyclicSort(int[] value) {
        int i = 0;
        while (i < value.length) {
            int correctIndex = value[i] - 1;
            // Swap until you find the correct element in the index
            if (value[i] != value[correctIndex]) {
                int temp = value[i];
                value[i] = value[correctIndex];
                value[correctIndex] = temp;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] value = {3, 5, 2, 1, 4, 2, 2};
        cyclicSort(value);
        System.out.println(Arrays.toString(value));
    }
}
