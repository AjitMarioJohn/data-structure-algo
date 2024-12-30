package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 * of at least one of the chosen numbers is different.
 * <p>
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 * <p>
 * Input: candidates = [2], target = 1
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 */
public class CombinationSum {

    /**
     * Finds out all the possible combinations based on given target
     *
     * @param candidate number array out of which combinations are to be made
     * @param target    combinations sum total should be equal to target
     * @return @{@link List} List of all the possible combinations
     */
    public List<List<Integer>> find(int[] candidate, int target) {
        List<List<Integer>> possibleCombinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        find(candidate, 0, target, combination, possibleCombinations);
        return possibleCombinations;
    }

    /**
     * recursive function to find out all combination
     *
     * @param candidate            number array out of which combinations are to be made
     * @param index                index of the element we are considering
     * @param remainingSum         remaining sum after subtracting all the element in current iteration
     * @param combination          present combination we are iterating upon
     * @param possibleCombinations all the possible combinations
     */
    private void find(int[] candidate, int index, int remainingSum, List<Integer> combination, List<List<Integer>> possibleCombinations) {
        if (remainingSum == 0) {
            possibleCombinations.add(new ArrayList<>(combination));
            return;
        }

        if (remainingSum < 0 || index == candidate.length) {
            return;
        }

        int num = candidate[index];
        combination.add(num);
        find(candidate, index, remainingSum - num, combination, possibleCombinations);
        combination.removeLast();
        find(candidate, index + 1, remainingSum, combination, possibleCombinations);
    }
}
