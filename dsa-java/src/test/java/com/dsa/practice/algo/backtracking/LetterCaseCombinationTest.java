package com.dsa.practice.algo.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LetterCaseCombinationTest {

    private LetterCaseCombination sut;

    @BeforeEach
    void initialize() {
        sut = new LetterCaseCombination();
    }

    @Test
    public void testPermutation_whenWordIs_a1b2() {
        String word = "a1b2";
        List<String> expected = List.of("a1B2", "a1b2", "A1b2", "A1B2");
        List<String> actual = sut.permutation(word);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testPermutation_whenWordIs_C() {
        String word = "C";
        List<String> expected = List.of("C", "c");
        List<String> actual = sut.permutation(word);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testPermutation_whenWordIs_3z4() {
        String word = "3z4";
        List<String> expected = List.of("3z4","3Z4");
        List<String> actual = sut.permutation(word);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

}