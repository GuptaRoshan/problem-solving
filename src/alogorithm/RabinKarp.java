package algorithm;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {
    private static final int BASE = 256;
    private static final int MOD = 1000000007;
    private static long[] powMod;

    private static void precomputePowers(int k) {
        powMod = new long[k];
        powMod[0] = 1;
        for (int i = 1; i < k; i++) {
            powMod[i] = (powMod[i - 1] * BASE) % MOD;
        }
    }

    private static long calculateHash(String s, int start, int end) {
        long hash = 0;
        for (int i = start; i < end; i++) {
            int charValue = s.charAt(i);
            hash = (hash * BASE + charValue) % MOD;
        }
        return hash;
    }


    private static long updateHash(long oldHash, char oldChar, char newChar, int patternLength) {
        long newHash = (oldHash * BASE - oldChar * powMod[patternLength - 1] * BASE + newChar) % MOD;
        return (newHash + MOD) % MOD;
    }

    public static List<Integer> findPattern(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        if (m > n) return occurrences;

        precomputePowers(m);

        long patternHash = calculateHash(pattern, 0, m);
        long textHash = calculateHash(text, 0, m);

        for (int i = 0; i <= n - m; i++) {
            if (textHash == patternHash) {
                if (text.substring(i, i + m).equals(pattern)) {
                    occurrences.add(i);
                }
            }

            if (i < n - m) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + m), m);
            }
        }

        return occurrences;
    }

    public static void main(String[] args) {
        String text = "abcderfxabc";
        String pattern = "ab";

        List<Integer> occurrences = findPattern(text, pattern);
        System.out.println("Pattern found at positions: " + occurrences);
    }
}