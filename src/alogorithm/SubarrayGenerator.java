package alogorithm;

import java.util.ArrayList;
import java.util.List;

public class SubarrayGenerator {

    public static List<List<Integer>> generateSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {

                List<Integer> subarray = new ArrayList<>();

                for (int i = start; i <= end; i++) {
                    subarray.add(arr[i]);
                }

                result.add(subarray);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        List<List<Integer>> subarrays = generateSubarrays(arr);

        System.out.println(generateSubarrays(arr));

    }
}
