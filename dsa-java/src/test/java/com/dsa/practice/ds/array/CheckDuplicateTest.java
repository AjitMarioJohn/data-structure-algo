package com.dsa.practice.ds.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckDuplicateTest {
    @Test
    void testHasDuplicate() {
        CheckDuplicate checker = new CheckDuplicate();

        int[] numsWithDuplicate = {1, 2, 3, 4, 2};
        assertTrue(checker.hasDuplicate(numsWithDuplicate), "Expected duplicates, but found none!");

        int[] numsWithoutDuplicate = {1, 2, 3, 4, 5};
        assertFalse(checker.hasDuplicate(numsWithoutDuplicate), "Expected no duplicates, but found some!");

        int[] emptyArray = {};
        assertFalse(checker.hasDuplicate(emptyArray), "Expected no duplicates for an empty array!");

        int[] singleElementArray = {42};
        assertFalse(checker.hasDuplicate(singleElementArray), "Expected no duplicates in a single-element array!");
    }

}