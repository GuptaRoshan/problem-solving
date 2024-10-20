package practice.string;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {

    public static void main(String[] args) {
        String s = "Bb";

        System.out.println(longestNiceSubstring(s));
    }



   // Brute force solution
    public static String longestNiceSubstring(String s) {

        char[] ch = s.toCharArray();
        StringBuilder result = new StringBuilder();


        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j <= ch.length; j++) {

                boolean flag = true;
                Set<Character> set = new HashSet<>();
                StringBuilder temp = new StringBuilder();

                int k = i;
                while (k < j) {
                    set.add(ch[k]);
                    k++;
                }

                k = i;
                while (k < j) {
                    char letter = ch[k];
                    if (Character.isLowerCase(letter) && !set.contains(Character.toUpperCase(letter))) {
                        flag = false;
                        break;

                    } else if (Character.isUpperCase(letter) && !set.contains(Character.toLowerCase(letter))) {
                        flag = false;
                        break;

                    }
                    temp.append(ch[k]);
                    k++;
                }


                if (flag && temp.length() > result.length()) {
                    result = temp;
                }

            }
        }

        return result.toString();
    }
}
