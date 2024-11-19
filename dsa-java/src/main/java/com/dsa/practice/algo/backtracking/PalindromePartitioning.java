package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        new PalindromePartitioning().partition("aab");
        new PalindromePartitioning().partition("a");
    }

    public void partition(String str) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        partitionHelper(str, 0, currentPartition, result);
        System.out.println(result);
    }

    private void partitionHelper(String str, int index, List<String> currentPartition, List<List<String>> result) {
        if (index == str.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int end = index; end < str.length(); end++) {
            if (isPalindrome(str, index, end)) {
                currentPartition.add(str.substring(index, end+1));
                partitionHelper(str, end+1, currentPartition, result);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
