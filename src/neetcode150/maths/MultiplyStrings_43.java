package neetcode150.maths;

public class MultiplyStrings_43 {

    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j; // stores carry
                int p2 = i + j + 1;  // stores result
                int sum = mul + pos[p2]; // carry + a multiplication result, in the next iteration p2 becomes carry

                pos[p1] += sum / 10; // add carry
                pos[p2] = (sum) % 10; // add result
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.isEmpty() && p == 0)) {
                sb.append(p);
            }
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        System.out.println(multiply(num1, num2));
    }
}
