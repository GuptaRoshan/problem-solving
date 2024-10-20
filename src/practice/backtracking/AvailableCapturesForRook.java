package practice.backtracking;

public class AvailableCapturesForRook {

    public static int numRookCaptures(char[][] board) {

        int[] rookLocation = new int[2];
        int result = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rookLocation = new int[]{i, j};
                }
            }
        }

        int[][] directions = {
                {-1, 0}, // up
                {1, 0},  // down
                {0, -1}, // left
                {0, 1}   // right
        };

        // Check each direction
        for (int[] direction : directions) {
            int x = rookLocation[0];
            int y = rookLocation[1];


            while (true) {
                x += direction[0];
                y += direction[1];

                // Check if the new position is out of bounds
                if (x < 0 || x >= 8 || y < 0 || y >= 8) {
                    break;
                }

                // Check if there's a pawn ('p') that can be captured
                if (board[x][y] == 'p') {
                    result++;
                    break;
                }

                // Stop if there's any other piece in the way (bishop or another rook)
                if (board[x][y] != '.') {
                    break;
                }
            }
        }

        return result;


    }


    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };

        System.out.println(numRookCaptures(board));
    }


}