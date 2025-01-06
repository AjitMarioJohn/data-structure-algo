package com.dsa.practice.algo.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PermutationIITest {

    private PermutationII sut;

    @BeforeEach
    void setUp() {
        sut = new PermutationII();
    }

    @Test
    public void testCase1() {
        int[] nums = {1,1,2};
        List<List<Integer>> expected = List.of(List.of(1,1,2), List.of(1,2,1), List.of(2,1,1));
        List<List<Integer>> actual = sut.permuteUnique(nums);

        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testCase2() {
        int[] nums = {1,2,3};
        List<List<Integer>> expected = List.of(List.of(1,2,3), List.of(1,3,2), List.of(2,1,3), List.of(2,3,1), List.of(3,1,2), List.of(3,2,1));
        List<List<Integer>> actual = sut.permuteUnique(nums);

        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }
}