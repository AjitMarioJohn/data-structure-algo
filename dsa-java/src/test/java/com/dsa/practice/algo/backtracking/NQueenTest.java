package com.dsa.practice.algo.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NQueenTest {

    private NQueen sut;

    @BeforeEach
    void initialize() {
        sut = new NQueen();
    }

    @Test
    public void testPlace_whenSizeIs_4() {
        int size = 4;
        List<List<String>> expected = List.of(List.of(".Q..","...Q","Q...","..Q."), List.of("..Q.","Q...","...Q",".Q.."));
        List<List<String>> actual = sut.placeQueen(size);

        assertEquals(expected, actual);
    }

    @Test
    public void testPlace_whenSizeIs_1() {
        int size = 1;
        List<List<String>> expected = List.of(List.of("Q"));
        List<List<String>> actual = sut.placeQueen(size);

        assertEquals(expected, actual);
    }

}