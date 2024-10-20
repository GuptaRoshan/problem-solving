package practice.string;

public class LongestHappyPrefix {

    // https://leetcode.com/problems/longest-happy-prefix/description/
    public static String longestPrefix(String s) {
        if (s.length() == 1) return "";

        int lpsIndex = 0;
        int[] lps = new int[s.length()];


        for (int i = 1; i < s.length(); ) {
            if (s.charAt(lpsIndex) == s.charAt(i)) {
                lpsIndex++;
                lps[i] = lpsIndex;
                i++;
            } else {

                if (lpsIndex != 0) {
                    lpsIndex = lps[lpsIndex - 1];
                } else {
                    i++;
                }

            }
        }

        return s.substring(0, lps[s.length() - 1]);
    }


    public static void main(String[] args) {
        String s = "acccbaaacccbaac";
        System.out.println(longestPrefix(s));

        s = "level";
        System.out.println(longestPrefix(s));
    }

}
