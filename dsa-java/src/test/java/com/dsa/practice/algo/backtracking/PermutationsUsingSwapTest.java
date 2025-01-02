package com.dsa.practice.algo.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PermutationsUsingSwapTest {

    private PermutationsUsingSwap sut;

    @BeforeEach
    void setUp() {
        sut = new PermutationsUsingSwap();
    }

    @Test
    public void testCase1() {
        int[] nums = {1,2,3};
        List<List<Integer>> expected = List.of(List.of(1,2,3),List.of(1,3,2),List.of(2,1,3),List.of(2,3,1),List.of(3,1,2),List.of(3,2,1));
        List<List<Integer>> actual = sut.permute(nums);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testCase2() {
        int[] nums = {0,1};
        List<List<Integer>> expected = List.of(List.of(0,1),List.of(1,0));
        List<List<Integer>> actual = sut.permute(nums);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testCase3() {
        int[] nums = {1};
        List<List<Integer>> expected = List.of(List.of(1));
        List<List<Integer>> actual = sut.permute(nums);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }
}