package leetcode.string;

public class BalancedStrings {

    public static int balancedStringSplit(String s) {
        int rCount = 0;
        int lCount = 0;

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                rCount++;
            } else if (s.charAt(i) == 'L') {
                lCount++;
            }

            if (rCount == lCount) {
                result++;
                rCount = 0;
                lCount = 0;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        //s = "RLRRRLLRLL";
        System.out.println(balancedStringSplit(s));
    }
}
