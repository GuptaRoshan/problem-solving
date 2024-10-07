package practice.array;

import java.util.Arrays;

@SuppressWarnings("all")
public class MatrixReshape {

    // https://leetcode.com/problems/reshape-the-matrix/description/

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;

        if (m * n != r * c) return mat;

        int[][] result = new int[r][c];

        int[] temp = new int[n * m];

        // First convert into 1D array, i * columnLength + j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i * m + j] = mat[i][j];
            }
        }

        // Then convert 1D array(i * columnLength + j) into required shape
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                result[i][j] = temp[i * c + j];
//            }
//        }

        for(int i = 0; i < temp.length; i++){
            result[i / c][ i % c] = temp[i];
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4}};
        int r = 2, c = 2;
        System.out.println(Arrays.deepToString(matrixReshape(mat, r, c)));
    }


}
