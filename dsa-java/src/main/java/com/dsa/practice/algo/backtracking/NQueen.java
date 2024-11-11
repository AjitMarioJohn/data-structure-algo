package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    private static final char EMPTY_CHAR = '.';
    private static final char Q = 'Q';

    public static void main(String[] args) {
        new NQueen().placeQueen(4);
    }
    public void placeQueen(int size) {
        char[][] board = new char[size][size];
        List<List<String>> resultant = new ArrayList<>();
        initialise(board);
        place(board, 0, resultant);
        System.out.println(resultant);
    }

    private void place(char[][] board, int row, List<List<String>> resultant) {
        if (row >= board.length) {
            createResultant(board, resultant);
            return;
        }

        for (int column = 0; column < board.length; column++) {
            if (!canInsert(board, row, column)) {
                continue;
            }

            board[row][column] = Q;
            place(board, row+1, resultant);
            board[row][column] = EMPTY_CHAR;
        }
    }

    private void createResultant(char[][] board, List<List<String>> resultant) {
        List<String> list = new ArrayList<>();
        for (char[] chars : board) {
            StringBuilder builder = new StringBuilder();
            for (int column = 0; column < board.length; column++) {
                builder.append(chars[column]);
            }
            list.add(builder.toString());
        }
        resultant.add(list);
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
