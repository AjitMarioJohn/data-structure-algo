package com.dsa.practice.algo.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexicographicalStringTest {

    private LexicographicalString sut;

    @BeforeEach
    void setUp() {
        sut = new LexicographicalString();
    }

    @Test
    public void testGetHappyStrings_whenNIs1_AndKIs3() {
        int n = 1;
        int k = 3;
        String expected = "c";

        assertEquals(expected, sut.getHappyString(n, k));
    }

    @Test
    public void testGetHappyStrings_whenNIs1_AndKIs4() {
        int n = 1;
        int k = 4;
        String expected = "";

        assertEquals(expected, sut.getHappyString(n, k));
    }

    @Test
    public void testGetHappyStrings_whenNIs3_AndKIs9() {
        int n = 3;
        int k = 9;
        String expected = "cab";

        assertEquals(expected, sut.getHappyString(n, k));
    }
}