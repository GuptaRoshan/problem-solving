package practice.string;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

    public static void main(String[] args) {
        String s = "IceCreAm";
        //System.out.println(reverseVowels(s)); // AceCreIm

        s = "leetcode";
        System.out.println(reverseVowels(s)); // leotcede
    }

    public static String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        Set<Character> vowelSet = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int i = 0;
        int j = ch.length - 1;

        while (i < j) {

            while (i < j && !vowelSet.contains(ch[i])) {
                i++;
            }

            while (i < j && !vowelSet.contains(ch[j])) {
                j--;
            }

            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;

            i++;
            j--;
        }

        return String.valueOf(ch);
    }

}
