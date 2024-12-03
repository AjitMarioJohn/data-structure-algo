package com.dsa.practice.algo.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordSearchTest {

    private WordSearch sut;

    @BeforeEach
    void setUp() {
        sut = new WordSearch();
    }

    @Test
    public void test_Exist_whenWord_ABCCED_exist() {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word =  "ABCCED";

        assertTrue(sut.exist(board, word));
    }

    @Test
    public void test_Exist_whenWord_SEE_exist() {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word =  "SEE";

        assertTrue(sut.exist(board, word));
    }

    @Test
    public void test_Exist_whenWord_ABCB_exist() {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word =  "ABCB";

        assertFalse(sut.exist(board, word));
    }
}