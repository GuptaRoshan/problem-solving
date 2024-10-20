package leetcode.string;

public class ShortestCompletingWord {

    // https://leetcode.com/problems/shortest-completing-word/description/
    // String matching
    // Can be optimized using primes
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int maxMatched = 0;
        String result = "";

        for (String currentWord : words) {
            int[] ascii = new int[256];

            for (int j = 0; j < currentWord.length(); j++) {
                int wc = currentWord.charAt(j);
                ascii[wc]++;
            }

            int currMatched = 0;
            for (int k = 0; k < licensePlate.length(); k++) {
                int lc = licensePlate.toLowerCase().charAt(k);

                if (ascii[lc] > 0) {
                    currMatched++;
                    ascii[lc]--;
                }
            }

            if (currMatched > maxMatched) {
                result = currentWord;
                maxMatched = currMatched;
            }else if (currMatched == maxMatched && currentWord.length() < result.length()){
                result = currentWord;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        String licensePlate = "1s3 456";
        String[] words = {"looks", "pest", "stew", "show"};
        System.out.println(shortestCompletingWord(licensePlate, words));
    }
}
