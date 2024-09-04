package neetcode150.arrayAndHashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings_271 {
    final static char DELIMITER = ';' ;

    /**
     * Encodes a list of strings to a single string.
     *
     * @param strs a list of strings
     * @return encoded string
     */
    public static String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String st : strs) {
            int length = st.length();
            result.append(length).append(DELIMITER).append(st);
        }
        return result.toString();
    }


    /**
     * Decodes a single string to a list of strings.
     *
     * @param str input string
     * @return list of decoded strings
     */
    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != DELIMITER) {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j + 1, j + 1 + length);
            result.add(word);
            i = j + 1 + length;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = List.of("design", "code", "loving", "coffee");
        String encodedString = encode(list);
        System.out.println(encodedString);
        System.out.println(decode(encodedString));
    }

}
