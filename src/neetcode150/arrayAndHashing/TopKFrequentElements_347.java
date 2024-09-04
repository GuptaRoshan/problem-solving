package neetcode150.arrayAndHashing;

import java.util.*;

public class TopKFrequentElements_347 {

    /**
     * Logic: Count the frequency of elements in the array and store them in a map and then use a priority queue to get the k most frequent elements.
     *
     * @param nums an integer array
     * @param k    an integer
     * @return the k most frequent elements
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Create record class to store key and count
        record Pair(Integer key, Integer count) {
        }

        // Priority Queue with custom comparator based on frequency
        Queue<Pair> queue = new PriorityQueue<>((a, b) -> b.count() - a.count());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            queue.add(new Pair(key, value));
        }

        int index = 0;
        int[] result = new int[k];
        while (!queue.isEmpty() && index < k) {
            Pair pair = queue.poll();
            result[index] = pair.key();
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.print(Arrays.toString(topKFrequent(nums, k)));
    }

}
