package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayUtil {


    public static void main(String[] args) {
        int[][] array2d = new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
        int[] array1d = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Fill with default values
        Arrays.fill(array1d, 0);

        // Sort in ascending order
        Arrays.sort(array1d);

        // Copied array
        int[] copiedArray = Arrays.copyOf(array1d, array1d.length);

        // Convert a arrayList list to array
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 2, 3));
        int[] listArray = list.stream().mapToInt(a -> a).toArray();

        String[] stringArray = {"1", "2", "3", "4", "5"};
        // Convert String[] to int[]
        int[] intArray = Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();

        // Sort array in descending order
        // Convert int[] to Integer[] to use Collections.reverseOrder()
        Integer[] array1dInteger = Arrays.stream(array1d).boxed().toArray(Integer[]::new);
        Arrays.sort(array1dInteger, Collections.reverseOrder());

        // Convert back to int[] if needed
        array1d = Arrays.stream(array1dInteger).mapToInt(Integer::intValue).toArray();

        String s ="hello world";
    }

}
