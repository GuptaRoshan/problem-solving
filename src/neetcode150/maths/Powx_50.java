package neetcode150.maths;

public class Powx_50 {

    // Example Walkthrough with x = 2.00000, n = 10:
    // Binary Representation of 10: 1010

    // Iteration 1:
    // n = 10, binary is 1010
    // n & 1 is 0 (since the LSB is 0), so pow remains 1
    // x is squared: x = 2.00000^2 = 4.00000
    // n is right-shifted: n = 5 (binary 101)

    // Iteration 2:
    // n = 5, binary is 101
    // n & 1 is 1 (since the LSB is 1), so pow is updated: pow = 1 * 4.00000 = 4.00000
    // x is squared: x = 4.00000^2 = 16.00000
    // n is right-shifted: n = 2 (binary 10)

    // Iteration 3:
    // n = 2, binary is 10
    // n & 1 is 0 (since the LSB is 0), so pow remains 4.00000
    // x is squared: x = 16.00000^2 = 256.00000
    // n is right-shifted: n = 1 (binary 1)

    // Iteration 4:
    // n = 1, binary is 1
    // n & 1 is 1 (since the LSB is 1), so pow is updated: pow = 4.00000 * 256.00000 = 1024.00000
    // x is squared: x = 256.00000^2 = 65536.00000
    // n is right-shifted: n = 0 (binary 0)

    public static double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double result = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                result *= x;
            }

            x *= x;
            n >>>= 1;

        }

        return result;
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }
}
