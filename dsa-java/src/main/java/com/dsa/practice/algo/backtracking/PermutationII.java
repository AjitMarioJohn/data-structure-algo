package com.dsa.practice.algo.backtracking;

import java.util.*;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class PermutationII {

    /**
     * Functions to find unique permutations
     * @param nums int array whose permutation we need to find
     * @return @{@link List} List of all the possible unique permutation
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, permutations);
        return permutations;
    }

    /**
     * recursive function to find out unique permutations of the arrays
     * @param nums int array whose permutation we have to find
     * @param index index we are iterating upon
     * @param permutations contains all the possible unique permutation
     */
    private void helper(int[] nums, int index, List<List<Integer>> permutations) {
        if (index == nums.length) {
            permutations.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        //Track element to avoid duplicate
        Set<Integer> seen = new HashSet<>();
        for (int secondIndex = index; secondIndex < nums.length; secondIndex++) {
            if (seen.add(nums[secondIndex])) {
                swap(nums, index, secondIndex);
                helper(nums, index+1, permutations);
                swap(nums, index, secondIndex);
            }
        }
    }

    /**
     * Swap the elements of two indexes in an array
     * @param nums int array whose element needs to swap
     * @param firstIndex first index to swap
     * @param secondIndex second index to swap
     */
    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }

}
