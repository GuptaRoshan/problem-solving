package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations_17 {

    private final String[] PHONE_BOOK = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // Iterative Version
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>(); // stores result

        // Base Case, when a digit is empty
        if (digits.isEmpty()) return combinations;

        combinations.add("");

        for (char digit : digits.toCharArray()) {
            List<String> currentCombinations = new ArrayList<>();

            for (String prefix : combinations) {
                String decodedString = PHONE_BOOK[digit - '0'];

                for (char ch : decodedString.toCharArray()) {
                    currentCombinations.add(prefix + ch);
                }
            }
            combinations = currentCombinations;
        }

        return combinations;
    }

    //------------------------------------------------------------------------------//

    // Recursive Version
    public List<String> letterCombinations0(String digits) {
        List<String> result = new LinkedList<>();
        if(digits == null || digits.isEmpty()) return result;

        combinationUtil("", digits, 0, result);
        return result;
    }


    private void combinationUtil(String prefix, String digits, int offset, List<String> result) {
        if (offset >= digits.length()) {
            result.add(prefix);
            return;
        }

        String letters = PHONE_BOOK[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combinationUtil(prefix + letters.charAt(i), digits, offset + 1, result);
        }
    }

    public static void main(String[] args) {
        String digits = "234";
        System.out.println( "Iterative Version : " +  new LetterCombinations_17().letterCombinations(digits));
        System.out.println( "\n");
        System.out.println( "Recursive Version : " +  new LetterCombinations_17().letterCombinations0(digits));
    }
}
