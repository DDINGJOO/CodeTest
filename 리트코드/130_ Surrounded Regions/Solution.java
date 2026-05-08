import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

class Solution {
    private static final char SAFE = '#';

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        IntStream.range(0, rows).forEach(row -> {
            markFromBorder(board, row, 0);
            markFromBorder(board, row, cols - 1);
        });

        IntStream.range(1, Math.max(1, cols - 1)).forEach(col -> {
            markFromBorder(board, 0, col);
            markFromBorder(board, rows - 1, col);
        });

        IntStream.range(0, rows).forEach(row ->
            IntStream.range(0, cols).forEach(col -> {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == SAFE) {
                    board[row][col] = 'O';
                }
            })
        );
    }

    private void markFromBorder(char[][] board, int startRow, int startCol) {
        if (board[startRow][startCol] != 'O') {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;
        Deque<Integer> stack = new ArrayDeque<>();

        board[startRow][startCol] = SAFE;
        stack.push(startRow * cols + startCol);

        while (!stack.isEmpty()) {
            int cell = stack.pop();
            int row = cell / cols;
            int col = cell % cols;

            mark(board, stack, row - 1, col);
            mark(board, stack, row + 1, col);
            mark(board, stack, row, col - 1);
            mark(board, stack, row, col + 1);
        }
    }

    private void mark(char[][] board, Deque<Integer> stack, int row, int col) {
        if (row < 0 || row == board.length || col < 0 || col == board[0].length) {
            return;
        }
        if (board[row][col] != 'O') {
            return;
        }

        board[row][col] = SAFE;
        stack.push(row * board[0].length + col);
    }
}
