package leetcode.string;

public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        String concatenatedString = s + s;
        String temp = concatenatedString.substring(1, concatenatedString.length() - 1);

        return temp.contains(s);
    }



    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(s));
    }
}
