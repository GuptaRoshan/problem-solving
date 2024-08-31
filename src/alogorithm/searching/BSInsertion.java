package alogorithm.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BSInsertion {

    public static int findInsertionPoint(List<Integer> list, int target) {
        int low = 0;
        int high = list.size(); // the only difference is we consider full list size here

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target <= list.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 3);

        int target = 4;
        int insertIndex = findInsertionPoint(list, target);
        list.add(insertIndex, target); // [1, 3, 4]


        target = 7;
        insertIndex = findInsertionPoint(list, target);
        list.add(insertIndex, target); // [1, 3, 5, 6, 7]

        System.out.println("List after insertion: " + list);
    }

}