package neetcode150.maths;

import java.util.Arrays;

public class RotateImage_48 {

    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */
    public static void rotateClockwise(int[][] matrix) {
        int n = matrix.length;

        // Reverse the matrix up to down
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        // Swap the symmetry
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /*
     * anticlockwise rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
     */
    public static void rotateAnticlockwise(int[][] matrix) {
        int n = matrix.length;

        // Reverse each row left to right
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++){
               int temp = matrix[i][j];
                matrix[i][j] =  matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

        // Swap the symmetry
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        //rotateClockwise(matrix);
        //System.out.println("Clockwise rotation:" + Arrays.deepToString(matrix));
        rotateAnticlockwise(matrix);
        System.out.println("Anti Clockwise rotation:" + Arrays.deepToString(matrix));


    }


}
