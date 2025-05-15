package com.dsa.practice.ds.array;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * <p>
 *     Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 * </p>
 * <pre>
 *     <b>Example 1</b>
 *     Input: nums = [1, 2, 3, 3]
 *     Output: true
 * </pre>
 *
 * <pre>
 *     <b>Example 1</b>
 *     Input: nums = [1, 2, 3, 4]
 *     Output: false
 * </pre>
 */
public class CheckDuplicate {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        return IntStream.of(nums).anyMatch(n -> !seen.add(n));

    }
}
