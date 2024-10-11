package practice.string;

public class ReverseString2 {

    public static void reverse(char[] ch, int start, int end) {
        end = Math.min(ch.length, end) - 1;

        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }

    public static String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();

        for (int start = 0; start < ch.length; start += 2 * k) {
           reverse(ch, start, start + k);
        }

        return new String(ch);
    }

    public static void main(String[] args){
       String s = "abcdefg";
       int k = 8;
       System.out.println(reverseStr(s, k));// gfedcba
    }


}
