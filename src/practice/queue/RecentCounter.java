package practice.queue;


import java.util.*;


// Can be solved using TreeSet and TreeMap, using tailSet and tailMap functions
public class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);

        while (t - 3000 > 0 && !queue.isEmpty() && queue.peek() < t - 3000) {
            queue.remove();
        }

        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();

        TreeSet<Integer> t = new TreeSet<>();
        t.tailSet(1);

        int[] value = {1, 100, 3001, 3002};
        value = new int[]{1178, 1483, 1563, 4054, 4152};
        value = new int[]{642, 1849, 4921, 5936, 5957}; // [null,1,2,1,2,3]  - [null,1,2,2,2,3]

        for (int j : value) {
            System.out.println(recentCounter.ping(j));
        }

    }

}
