package com.dsa.practice.algo.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LetterTilesTest {

    private LetterTiles sut;

    @BeforeEach
    void initialize() {
        sut = new LetterTiles();
    }

    @Test
    public void testPossibilities_whenWordIs_AAB() {
        final String tile = "AAB";
        List<String> expected = List.of("A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA");
        List<String> actual = sut.possibilities(tile);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testPossibilities_whenWordIs_AAABBC() {
        final String tile = "AAABBC";
        int expected = 188;
        List<String> actual = sut.possibilities(tile);

        assertEquals(expected, actual.size());
    }
}