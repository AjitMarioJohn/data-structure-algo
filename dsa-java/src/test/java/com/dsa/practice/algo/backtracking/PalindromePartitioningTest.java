package com.dsa.practice.algo.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromePartitioningTest {

    private PalindromePartitioning sut;

    @BeforeEach
    void initialize() {
        sut = new PalindromePartitioning();
    }

    @Test
    public void testPartition_whenWordIs_aab() {
        String word = "aab";
        List<List<String>> expected = List.of(List.of("a", "a", "b"), List.of("aa", "b"));
        List<List<String>> actual = sut.partition(word);

        System.out.println(actual);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testPartition_whenWordIs_a() {
        String word = "a";
        List<List<String>> expected = List.of(List.of("a"));
        List<List<String>> actual = sut.partition(word);

        System.out.println(actual);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

}