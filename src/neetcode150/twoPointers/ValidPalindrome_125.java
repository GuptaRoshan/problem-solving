package neetcode150.twoPointers;

public class ValidPalindrome_125 {

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     *
     * @param s input string
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String s) {
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char firstChar = s.charAt(start);
            char lastChar = s.charAt(last);

            if (!Character.isLetterOrDigit(firstChar)) {
                start++;
                continue;
            }

            if (!Character.isLetterOrDigit(lastChar)) {
                last--;
                continue;
            }

            if (Character.toLowerCase(firstChar) != Character.toLowerCase(lastChar)) {
                return false;
            }

            start++;
            last--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

}
