package com.dsa.practice.algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new CombinationSum().find(new int[]{2,3,6,7}, 7));
        System.out.println(new CombinationSum().find(new int[]{2,3,5}, 8));
        System.out.println(new CombinationSum().find(new int[]{2}, 1));
    }
    public List<List<Integer>> find(int[] candidate, int target) {
        List<List<Integer>> possibleCombinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        find(candidate, 0, target, combination, possibleCombinations);
        return possibleCombinations;
    }

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
        find(candidate, index, remainingSum-num, combination, possibleCombinations);
        combination.remove(combination.size() - 1);
        find(candidate, index+1, remainingSum, combination, possibleCombinations);
    }
}
