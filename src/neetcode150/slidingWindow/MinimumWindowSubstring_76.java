package neetcode150.slidingWindow;

public class MinimumWindowSubstring_76 {

    public static String minWindow(String source, String target) {
        // Handling edge cases
        if (source.length() < target.length()) return "";

        int[] frequency = new int[128]; // ASCII map
        int count = target.length(); // Number of characters to be found
        int start = 0; // Start pointer of a window
        int end = 0; // End pointer of a window
        int minLen = Integer.MAX_VALUE; // Minimum length of substring
        int startIndex = 0; // Start index of the substring

        for (char ch : target.toCharArray()) {
            frequency[ch]++; // Frequency of each character in target
        }

        while (end < source.length()) {
            // If the frequency count is greater than 0, then it means we have found a character of target in source
            // Because we created frequency count of target characters
            // Decrement the count, we found one character
            if (frequency[source.charAt(end)] > 0) {
                count--;
            }

            // If we found target in a source, then source.charAt(end) will be 0
            // If we did not find target in a source, then source.charAt(end) will be -1
            frequency[source.charAt(end)]--;
            end++;

            // If we found a substring, or if all the characters of target are found in a source
            // Shrink the window
            while (count == 0) {
                // Before Shrink, check if the window size is minimum of previous window size
                if (end - start < minLen) {
                    minLen = end - start; // Update the minimum length
                    startIndex = start; // Update the start index of the substring
                }

                // frequency[source.charAt(start)] == 0 means character match between target and source
                // frequency[source.charAt(start)] == negative means character does not match between target and source
                // Decrement the count to find the next character
                if (frequency[source.charAt(start)] == 0) {
                    count++;
                }

                // Reset the frequency count of the character
                // It will make it > 0 for matched characters, and 0 for unmatched characters
                // Reset the frequency count after operation from line-30 so in next iteration,
                // we can check if the character is matched or not
                frequency[source.charAt(start)]++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : source.substring(startIndex, startIndex + minLen);
    }


    public static void main(String[] args) {
        String source = "ADOBECODEBANC";
        String target = "ABC";
        System.out.println(minWindow(source, target));
    }

}
