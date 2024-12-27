package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every
 * substring
 *  of the partition is a
 * palindrome
 * . Return all possible palindrome partitioning of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
public class PalindromePartitioning {

    /**
     * returns all the partitions that are palindrome
     * @param word whose palindrome partition we have to find
     * @return @{@link List} all the partitions that are palindrome
     */
    public List<List<String>> partition(String word) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();

        partitionHelper(word, 0, currentPartition, partitions);

        return partitions;
    }

    /**
     * recursive function to find all the partition that are palindrome
     * @param word whose palindrome partition we have to find
     * @param index from where partition needs to start
     * @param currentPartition partition which we are testing
     * @param partitions contains all the partition that are palindrome
     */
    private void partitionHelper(String word, int index, List<String> currentPartition, List<List<String>> partitions) {
        if (index == word.length()) {
            partitions.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int endIndex = index; endIndex < word.length(); endIndex++) {
            if (isPalindrome(word, index, endIndex)) {
              currentPartition.add(word.substring(index, endIndex+1));
              partitionHelper(word, endIndex+1, currentPartition, partitions);
              currentPartition.removeLast();
            }
        }
    }

    /**
     * Checks whether the substring of the word is palindrome or not
     * @param word whose substring we have to check whether it is palindrome or not
     * @param startIndex start index of the substring
     * @param endIndex end index of the substring
     * @return
     */
    private boolean isPalindrome(String word, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {

            if (word.charAt(startIndex) != word.charAt(endIndex)) {
                return false;
            }

            startIndex++;
            endIndex--;
        }
        return true;
    }

}
