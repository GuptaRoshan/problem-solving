package alogorithm.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BSInsertion {

    public static int findInsertionPoint(List<Integer> list, int target) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 3, 5, 6);

        int target = 9;
        int insertIndex = findInsertionPoint(list, target); // 4
        list.add(insertIndex, target); // [1, 3, 5, 6, 9]


        target = 7;
        insertIndex = findInsertionPoint(list, target); // 4
        list.add(insertIndex, target); // [1, 3, 5, 6, 7, 9]

        System.out.println("List after insertion: " + list);
    }

}