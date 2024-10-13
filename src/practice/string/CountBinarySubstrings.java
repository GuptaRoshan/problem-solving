package practice.string;

public class CountBinarySubstrings {

    // https://leetcode.com/problems/count-binary-substrings/description/
    // Count consecutive chars, keep a pointer of previous and current consecutive count and sum the min consecutive count of prev and current
    public static int countBinarySubstrings(String s) {
        int currentCounter = 1;
        int prevCounter = 0;
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                currentCounter++;
            } else {
                result += Math.min(prevCounter, currentCounter);
                prevCounter = currentCounter;
                currentCounter = 1;
            }
        }

        result += Math.min(prevCounter, currentCounter);

        return result;
    }


    public static void main(String[] args) {
        String s = "00110011";
        System.out.println(countBinarySubstrings(s));
    }

}
