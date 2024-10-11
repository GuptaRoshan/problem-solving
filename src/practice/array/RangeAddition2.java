package practice.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeAddition2 {

    public static int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) return m * n;

        int row = Integer.MAX_VALUE;
        int col = Integer.MAX_VALUE;

        for (int[] op : ops) {
            row = Math.min(row, op[0]);
            col = Math.min(col, op[1]);
        }

        return row * col;
    }


    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] ops = {{2, 2}, {3, 3}};
        System.out.println(maxCount(m, n, ops));
    }
}
