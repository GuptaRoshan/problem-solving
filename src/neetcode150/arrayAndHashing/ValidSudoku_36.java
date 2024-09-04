package neetcode150.arrayAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_36 {

    /**
     * check if the given board is valid sudoku
     * 
     * @param board 9x9 2D array
     * @return true if the board is valid sudoku, false otherwise
     */
    public static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                // Calculate sub grid number
                int gridNumber = (i / 3) * 3 + (j / 3);
                // Add row, column and grid number to the set if adding fails(there is duplicate) return false
                if (!set.add("row" + i + board[i][j]) ||  !set.add("column" + j + board[i][j]) ||  !set.add("grid" + gridNumber + board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
