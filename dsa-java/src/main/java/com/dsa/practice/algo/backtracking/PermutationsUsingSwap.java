package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible
 * permutations
 * . You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class PermutationsUsingSwap {

    /**
     * List out all the possible permutations with the given array. This is more optimized solution then @{@link Permutations}
     * @param nums int array from which permutations needs to be made
     * @return @{@link List} List of all the possible permutation
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        helper(nums, 0, permutations);

        return permutations;
    }

    /**
     * recursive function to find all the possible permutation using swap logic
     * @param nums int array whose permutations are to be made
     * @param index index of the element we want to swap
     * @param permutations consist of all the possible permutations
     */
    private void helper(int[] nums, int index, List<List<Integer>> permutations) {
        if (index == nums.length) {
            permutations.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        // starting from the index and iterating over
        for (int secondIndex = index; secondIndex < nums.length; secondIndex++) {
            // swapping the to indexes
            swap(nums, index, secondIndex);
            helper(nums, index+1, permutations);
            // swapping again to bring back to original value
            swap(nums, index, secondIndex);
        }
    }

    /**
     * Swapping two indexes among themselves
     * @param nums int array whose index are to be swapped
     * @param firstIndex index 1 to swap
     * @param secondIndex index 2 to swap
     */
    private void swap(int[] nums, int firstIndex, int secondIndex) {
        //storing in temporary variable
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }
}
