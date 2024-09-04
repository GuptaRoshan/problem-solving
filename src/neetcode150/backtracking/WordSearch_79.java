package neetcode150.backtracking;

public class WordSearch_79 {

    public static boolean wordExist(char[][] board, int row, int col, char[] wordChar, int i) {

        if (wordChar.length == i) {
            return true;
        }

        if (row > board.length - 1 || col > board[0].length - 1 || row < 0 || col < 0) {
            return false;
        }

        if (wordChar[i] != board[row][col]) {
            return false;
        }

        board[row][col] = '*';

        boolean isExist = wordExist(board, row - 1, col, wordChar, i + 1) ||
                wordExist(board, row, col - 1, wordChar, i + 1) ||
                wordExist(board, row, col + 1, wordChar, i + 1) ||
                wordExist(board, row + 1, col, wordChar, i + 1);

        board[row][col] = wordChar[i];

        return isExist;
    }


    public static boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                if (wordExist(board, row, col, wordChar, 0)) {
                    return true;
                }

            }
        }
        return false;
    }


    public static void main(String[] args){
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";

        System.out.println(exist(board, word));
    }


}
