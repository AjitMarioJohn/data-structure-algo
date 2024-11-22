package com.dsa.practice.algo.backtracking;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 */
public class NQueenII {
    private static final char EMPTY_CHAR = '.';
    private static final char Q = 'Q';

    public static void main(String[] args) {
        System.out.println(new NQueenII().totalNQueens(4));;
    }

    public int totalNQueens(int size) {
        char[][] board = new char[size][size];
        initialise(board);
        return place(board, 0);
    }

    private int place(char[][] board, int row) {
        if (row >= board.length) {
            return 1;
        }

        int distinctCount = 0;
        for (int column = 0; column < board.length; column++) {
            if (!canInsert(board, row, column)) {
                continue;
            }
            board[row][column] = Q;
            distinctCount += place(board, row+1);
            board[row][column] = EMPTY_CHAR;
        }
        return distinctCount;
    }

    private boolean canInsert(char[][] board, final int row, final int column) {
        for (int index = 0; index < board.length; index++) {
            if (board[index][column] == Q) {
                return false;
            }
        }

        for (int rowNum = row, col = column; rowNum >= 0 && col >= 0;  rowNum--, col--) {
            if (board[rowNum][col] == Q) {
                return false;
            }
        }

        for (int rowNum = row, col = column; rowNum >= 0 && col < board.length;  rowNum--, col++) {
            if (board[rowNum][col] == Q) {
                return false;
            }
        }
        return true;
    }

    private void initialise(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                board[row][column] = EMPTY_CHAR;
            }
        }
    }
}
