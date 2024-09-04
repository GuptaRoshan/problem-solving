package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {


    // Check string is palindrome or not
    private boolean isPalindrome(String str) {
        int leftPointer = 0, rightPointer = str.length() - 1;
        while (leftPointer <= rightPointer) {
            if (str.charAt(leftPointer) != str.charAt(rightPointer)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }


    private void findPartitions(String remaining, List<String> currentPartition, List<List<String>> allPartitions) {

        // Base case: If there is no remaining substring, add the current partition to the result
        if (remaining == null || remaining.isEmpty()) {
            allPartitions.add(new ArrayList<>(currentPartition));
            return;
        }

        // Explore all possible substrings
        for (int endIndex = 1; endIndex <= remaining.length(); endIndex++) {

            String substring = remaining.substring(0, endIndex);
            //System.out.println(substring);

            if (!isPalindrome(substring)) continue; // Skip non-palindromic substrings

            currentPartition.add(substring);  // Choose the current palindromic substring

            findPartitions(remaining.substring(endIndex), currentPartition, allPartitions); // Explore further

            currentPartition.removeLast(); // Unchoose the last substring
        }
    }

    public List<List<String>> partition(String input) {
        // Handle edge cases where input is null or empty
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        List<List<String>> partitions = new ArrayList<>();
        findPartitions(input, new ArrayList<>(), partitions);
        return partitions;
    }


    public static void main(String[] args){
        String str = "abcd";
        new PalindromePartitioning_131().partition(str);
    }


}
