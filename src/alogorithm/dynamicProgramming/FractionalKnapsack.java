package alogorithm.dynamicProgramming;

import java.util.Arrays;

public class FractionalKnapsack {

    /**
     * Algorithm to solve fractional knapsack problem
     * <p>
     * Step 1. Calculate value-to-weight ratios for each item
     * Step 2. Sort items by value-to-weight ratio in decreasing order
     * Step 3. Take items with the highest value-to-weight ratio until the knapsack is full
     * Step 4. Return the total value of items taken
     *
     * @param values   values of items
     * @param weights  weights of items
     * @param capacity capacity of knapsack
     * @return maximum value that can be obtained
     */
    public static double fractionalKnapsack(int[] values, int[] weights, int capacity) {
        record Item(int value, int weight, double ratio) {
        }

        Item[] itemList = new Item[values.length];
        for (int i = 0; i < values.length; i++) {
            itemList[i] = new Item(values[i], weights[i], (double) values[i] / weights[i]);
        }

        // Sort items by value/weight ratio in descending order
        Arrays.sort(itemList, (item1, item2) -> Double.compare(item2.ratio, item1.ratio));

        double totalValue = 0.0;
        double remainingCapacity = capacity;

        for (Item item : itemList) {
            if (remainingCapacity >= item.weight) {
                // Add the entire item if it fits
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // Add a fraction of the item if knapsack is full
                double fraction = remainingCapacity / item.weight;
                totalValue += item.value * fraction;
                break;
            }
        }

        return totalValue;
    }


    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        double maxValue = fractionalKnapsack(values, weights, capacity);
        System.out.println("Maximum value that can be obtained: $" + maxValue);
    }
}

