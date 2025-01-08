package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 *
 * Return a list of all possible strings we could create. Return the output in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * Example 2:
 *
 * Input: s = "3z4"
 * Output: ["3z4","3Z4"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 12
 * s consists of lowercase English letters, uppercase English letters, and digits.
 */
public class LetterCaseCombination {

    /**
     * Find out all the possible permutations of letter case
     * @param word whose permutation needs to made
     * @return @{@link List<String>} all the possible permutations
     */
    public List<String> permutation(String word) {
        List<String> permutations = new ArrayList<>();
        helper(word, 0, word.toCharArray(), permutations);
        return permutations.stream().toList();
    }

    /**
     * recursive function to find out all possible permutation by case for the given word
     * @param word word on which we have to find ppermutation
     * @param index index of the character
     * @param currentPermutation
     * @param permutations
     */
    private void helper(String word, int index, StringBuilder currentPermutation, List<String> permutations) {
        if (index == word.length()) {
            permutations.add(currentPermutation.toString());
            return;
        }

        char indexChar = word.charAt(index);
        // adding with UPPER CASE
        if (Character.isAlphabetic(indexChar)) {
            currentPermutation.setCharAt(index, Character.toUpperCase(indexChar));
            helper(word, index+1, currentPermutation, permutations);

            currentPermutation.setCharAt(index, Character.toLowerCase(indexChar));
            helper(word, index+1, currentPermutation, permutations);
        } else {
            helper(word, index+1, currentPermutation, permutations);
        }
    }

    /**
     *Certainly! For the letter case permutation problem, using char[] is generally more efficient compared to StringBuilder. Here's why:
     *
     * Performance: char[] allows for direct, low-level manipulation of characters with minimal overhead. This makes it faster for tasks involving frequent changes to individual characters.
     *
     * Memory Usage: char[] is more memory-efficient as it doesn't carry the additional overhead associated with a dynamic structure like StringBuilder.
     */
    private void helper(String word, int index, char[] currentPermutation, List<String> permutations) {
        if (index == word.length()) {
            permutations.add(new String(currentPermutation));
            return;
        }

        char indexChar = word.charAt(index);
        // adding with UPPER CASE
        if (Character.isAlphabetic(indexChar)) {
            currentPermutation[index] = Character.toUpperCase(indexChar);
            helper(word, index+1, currentPermutation, permutations);

            currentPermutation[index] = Character.toLowerCase(indexChar);
            helper(word, index+1, currentPermutation, permutations);
        } else {
            helper(word, index+1, currentPermutation, permutations);
        }
    }

}
