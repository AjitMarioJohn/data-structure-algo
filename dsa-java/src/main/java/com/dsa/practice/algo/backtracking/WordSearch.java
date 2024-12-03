package com.dsa.practice.algo.backtracking;

public class WordSearch {

    private final static char VISITED_INDEX_CHAR = '#';

    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == word.charAt(0) && exist(board, word, row, column, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int row, int column, int wordIndex) {
        // entire word is matched
        if (wordIndex >= word.length()) {
            return true;
        }

        // check row and column under limit || whether the index was visited || character at index match
        if (row < 0 || column < 0 || row >= board.length || column >= board[row].length ||
                board[row][column] == VISITED_INDEX_CHAR || board[row][column] != word.charAt(wordIndex)) {
            return false;
        }

        char temp = board[row][column];
        //setting as visited index for future iteration
        board[row][column] = VISITED_INDEX_CHAR;

        // checking all the sequentially adjacent cells (right, left, up, down)
        boolean found = exist(board, word, row, column+1, wordIndex+1) ||
                exist(board, word, row, column-1, wordIndex+1) ||
                exist(board, word, row - 1, column, wordIndex+1) ||
                exist(board, word, row + 1, column, wordIndex+1);

        board[row][column] = temp;
        return found;
    }
}
