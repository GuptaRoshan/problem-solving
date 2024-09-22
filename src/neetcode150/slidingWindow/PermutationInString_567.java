package neetcode150.slidingWindow;

public class PermutationInString_567 {

    public static boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] frequency = new int[26];

        // Initialize the frequency map with characters from s1
        for (int i = 0; i < m; i++) {
            frequency[s1.charAt(i) - 'a']--;
        }

        int i = 0, j = 0;

        while (j < n) {
            int k = s2.charAt(j) - 'a';
            frequency[k]++;

            // Adjust the window if the current character frequency is higher than zero
            while (frequency[k] > 0) {
                frequency[s2.charAt(i) - 'a']--;
                i++;
            }

            // Check if the window matches the length of s1
            if (j - i + 1 == m) return true;

            // Move the window to the right
            j++;
        }

        return false;
    }


    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        System.out.println(checkInclusion(s1, s2));
    }

}
