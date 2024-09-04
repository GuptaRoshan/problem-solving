package neetcode150.greedy;

import java.util.*;

public class HandOfStraights_846 {

    // Using MinHeap
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int card : hand) {
            minHeap.add(card);
        }

        while (!minHeap.isEmpty()) {
            int start = minHeap.poll();

            for (int i = 1; i < groupSize; i++) {
                if (minHeap.remove(start + i)) continue;
                return false;
            }
        }

        return true;
    }

    // Using Treemap
    public static boolean isNStraightHand2(int[] hand, int groupSize) {
        // default sorting in ascending order
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
        for (int card : hand) {
            sortedMap.put(card, sortedMap.getOrDefault(card, 0) + 1);
        }

        while (!sortedMap.isEmpty()) {
            int firstKey = sortedMap.firstKey();
            for (int i = firstKey; i < firstKey + groupSize; i++) {
                if (!sortedMap.containsKey(i)) return false;

                sortedMap.put(i, sortedMap.get(i) - 1);
                if (sortedMap.get(i) == 0) sortedMap.remove(i);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
        System.out.println(isNStraightHand2(hand, groupSize));
    }

}