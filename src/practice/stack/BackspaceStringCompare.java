package practice.stack;

public class BackspaceStringCompare {

    public static String formatString(String str) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);

            if (c == '#') {
                count++;
                continue;
            }

            if (count == 0) {
                result.insert(0, c);
            } else {
                count--;
            }
        }

        return result.toString();
    }

    public static  boolean backspaceCompare(String s, String t) {
        return formatString(s).equals(formatString(t));
    }

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";

        System.out.println(backspaceCompare(s, t));
    }
}
