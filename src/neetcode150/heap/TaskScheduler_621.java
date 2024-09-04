package neetcode150.heap;

import java.util.Arrays;

public class TaskScheduler_621 {

    public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        int[] frequency = new int[26];
        /* Build the count array with the frequency of each task */
        for (char c : tasks) {
            frequency[c - 'A']++;
        }
        Arrays.sort(frequency);

        /* Get maximum frequency task  and calculate max idle spaces*/
        // A _ _ A _ _ A
        int unfilledGaps = frequency[25] - 1;
        int idleSpaces = unfilledGaps * n;

        /* Iterate over the rest of the array and reduce the idle space count */
        for (int i = 24; i >= 0; i--) {
            idleSpaces = idleSpaces -  Math.min(unfilledGaps, frequency[i]);
        }
        /* Handle cases when spaces become negative */
        idleSpaces = Math.max(0, idleSpaces);
        return tasks.length + idleSpaces;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
}
