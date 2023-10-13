import java.time.Duration;
import java.time.Instant;

/**
 * RecursionTests : SudokuSolver
 *
 * @author viaen
 * @version 10/10/2023
 */
public class SudokuSolver {
    static int[][] board = {
            {0, 0, 0, 0, 7, 0, 0, 0, 1},
            {0, 0, 5, 0, 0, 1, 7, 4, 3},
            {2, 0, 0, 8, 0, 0, 6, 9, 5},
            {0, 0, 2, 0, 0, 0, 0, 7, 0},
            {0, 0, 0, 6, 0, 5, 0, 0, 0},
            {0, 9, 0, 0, 0, 0, 3, 0, 0},
            {8, 5, 3, 0, 0, 6, 0, 0, 7},
            {6, 7, 9, 1, 0, 0, 4, 0, 0},
            {1, 0, 0, 0, 8, 0, 0, 0, 0}
    };



    static final int GRID_SIZE = 9;

    static void printBoard() {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row == 3 || row == 6) System.out.println("---------------------");
            for (int column = 0; column < GRID_SIZE; column++) {
                if (column == 3 || column == 6) System.out.print("| ");
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }

    static boolean isInRow(int[][] board, int value, int row) {
        for (int column = 0; column < GRID_SIZE; column++) {
            if (board[row][column] == value) return true;
        }
        return false;
    }

    static boolean isInColumn(int[][] board, int value, int column) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (board[row][column] == value) return true;
        }
        return false;
    }

    static boolean isInSquare(int[][] board, int value, int row, int column) {
        int localSquareRow = row - row % 3;
        int localSquareColumn = column - column % 3;

        for (int i = localSquareRow; i < localSquareRow + 3; i++) {
            for (int j = localSquareColumn; j < localSquareColumn + 3; j++) {
                if (board[i][j] == value) return true;
            }
        }
        return false;
    }

    static boolean isValidPlacement(int[][] board, int value, int row, int column) {
        return !isInColumn(board, value, column) && !isInRow(board, value, row) && !isInSquare(board, value, row, column);
    }

    static boolean solveBoard(int[][] board) {

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (board[row][column] == 0) {
                    for (int valueToTry = 1; valueToTry <= GRID_SIZE; valueToTry++) {
                        if (isValidPlacement(board, valueToTry, row, column)) {
                            board[row][column] = valueToTry;
                            if (solveBoard(board)) {
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Unsolved Sudoku: ");
        printBoard();
        Instant starts = Instant.now();
        Thread.sleep(10);
        solveBoard(board);
        System.out.println("Solved Sudoku: ");
        printBoard();
        Instant ends = Instant.now();
        System.out.println(Duration.between(starts, ends));
    }

}
