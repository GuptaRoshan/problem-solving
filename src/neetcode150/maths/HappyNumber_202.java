package neetcode150.maths;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {

    public static boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum, remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n % 10; // get the last digit
                squareSum += remain * remain; // add the square of the last digit
                n /= 10; // remove the last digit
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }

        return false;
    }

    public static void main(String[] args){
        int n = 19;
        System.out.println(isHappy(n)); // Output: true
    }
}
