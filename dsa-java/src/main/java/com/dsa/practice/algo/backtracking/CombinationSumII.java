package com.dsa.practice.algo.backtracking;

import java.util.*;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 *
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class CombinationSumII {

    public static void main(String[] args) {
        System.out.println(new CombinationSumII().find(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(new CombinationSumII().find(new int[]{2,5,2,1,2}, 5));
    }

    public List<List<Integer>> find(int[] arr, int target) {
        Set<List<Integer>> resultant = new HashSet<>();
        List<Integer> runningSet = new ArrayList<>();

        Arrays.sort(arr);
        find(arr, runningSet, resultant, target, 0);

        return new ArrayList<>(resultant);
    }

    private void find(int[] arr, List<Integer> runningSet, Set<List<Integer>> resultant, int remainingSum, int index) {
        if (remainingSum == 0) {
            resultant.add(new ArrayList<>(runningSet));
            return;
        }

        if (remainingSum < 0 || index >= arr.length) {
            return;
        }

        int num = arr[index];
        runningSet.add(num);
        find(arr, runningSet, resultant, remainingSum - num, index+1);
        runningSet.remove(runningSet.size() - 1);
        find(arr, runningSet, resultant, remainingSum, index+1);
    }

}
