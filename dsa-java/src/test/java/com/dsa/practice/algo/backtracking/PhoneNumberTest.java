package com.dsa.practice.algo.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneNumberTest {

    private PhoneNumber sut;

    @BeforeEach
    void initialize() {
        sut = new PhoneNumber();
    }

    @Test
    public void testLetterCombination_whenDigitIs23() {
        final String digit = "23";
        List<String> expected = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        List<String> actual = sut.letterCombination(digit);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testLetterCombination_whenDigitIs2() {
        final String digit = "2";
        List<String> expected = List.of("a","b","c");
        List<String> actual = sut.letterCombination(digit);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testLetterCombination_whenDigitIsEmpty() {
        final String digit = "";
        List<String> actual = sut.letterCombination(digit);

        assertTrue(actual.isEmpty());
    }

}