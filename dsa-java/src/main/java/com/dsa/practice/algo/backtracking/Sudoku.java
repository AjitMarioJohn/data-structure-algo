package com.dsa.practice.algo.backtracking;

import java.util.Arrays;

public class Sudoku {
    private static final char EMPTY_CHAR = '.';

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
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
        sudoku.solve(board);
    }

    public void solve(char[][] input) {
        char[][] board = Arrays.copyOf(input, input.length);
        printBoard(board);
        printBoard(board);
        System.out.println("=========================================");
        solvePuzzle(board);
        printBoard(board);
    }

    private boolean solvePuzzle(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                if (board[row][column] != EMPTY_CHAR) {
                    continue;
                }

                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, row, column, num)) {
                        board[row][column] = num;

                        if (solvePuzzle(board)) {
                            return true;
                        } else {
                            board[row][column] = EMPTY_CHAR;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int column, char num) {
        int boxRowStart = 3 * (row / 3);
        int boxColStart = 3 * (column / 3);
        for (int index = 0; index < board.length; index++) {
            if (board[row][index] == num || board[index][column] == num || board[boxRowStart+index/3][boxColStart+index%3] == num) {
                return false;
            }
        }
        return true;
    }

    private void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char col : row) {
                System.out.print(col);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
