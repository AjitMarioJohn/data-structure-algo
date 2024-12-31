package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
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
public class Permutations {

    /**
     * List out all the possible permutations with the given array
     * @param nums int array from which permutations needs to be made
     * @return @{@link List} List of all the possible permutation
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> currentPermutations = new ArrayList<>();
        // used to mark the indexes that are already considered
        boolean[] used = new boolean[nums.length];
        helper(nums, used, currentPermutations, permutations);

        return permutations;
    }

    /**
     * recursive function to find out all the possible permutation
     * @param nums int array from which permutations needs to be made
     * @param used array that tracks which indexes are already considered in present permutation
     * @param currentPermutations ongoing permutation
     * @param permutations
     */
    private void helper(int[] nums, boolean[] used, List<Integer> currentPermutations, List<List<Integer>> permutations) {
        if (currentPermutations.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPermutations));
            return;
        }

        for (int index = 0; index < nums.length; index++) {
            if (used[index]) {
                continue;
            }

            // mark index as considered
            used[index] = true;
            currentPermutations.add(nums[index]);
            helper(nums, used, currentPermutations, permutations);
            currentPermutations.removeLast();
            // unmark index
            used[index] = false;
        }
    }
}
