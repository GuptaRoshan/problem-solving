package practice.array;

public class Palindrome {

    // https://leetcode.com/problems/palindrome-number/submissions/1404675728/
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int n = str.length();

        // if its n is odd then it will skip a middle element, if its even then it compares all the elements
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}
