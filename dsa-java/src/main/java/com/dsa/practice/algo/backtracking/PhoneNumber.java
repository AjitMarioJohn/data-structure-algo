package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 * <p>
 *  Example 1:
 *  Input: digits = "23"
 *  Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * </p>
 * <p>
 *  Example 2:
 *  Input: digits = ""
 *  Output: []
 * </p>
 * <p>
 *  Example 3:
 *  Input: digits = "2"
 *  Output: ["a","b","c"]
 * </p>
 *
 *<p>
 * Constraints
 * <p> 1. 0 <= digits.length <= 4</p>
 * <p> 2. digits[i] is a digit in the range ['2', '9'].</p>
 *</p>
 */

public class PhoneNumber {

    // Contains map of digit with it's letters as per phone keypad
    private final static Map<Character, String> digitToLetterMap = new HashMap<>();

    // initializing at the class load
    static {
        digitToLetterMap.put('2', "abc");
        digitToLetterMap.put('3', "def");
        digitToLetterMap.put('4', "ghi");
        digitToLetterMap.put('5', "jkl");
        digitToLetterMap.put('6', "mno");
        digitToLetterMap.put('7', "pqrs");
        digitToLetterMap.put('8', "tuv");
        digitToLetterMap.put('9', "wxyz");
    }

    /**
     * Returns all the combination
     *
     * @param digit whose combinations are to be made
     * @return @{@link List} contains all the possible combination
     */
    public List<String> letterCombination(String digit) {
        List<String> combinations = new ArrayList<>();
        if (digit.isEmpty()) {
            return combinations;
        }
        helper(digit, 0, new StringBuilder(), combinations);
        return combinations;
    }

    /**
     * recursive function to get all the possible combinations
     * @param digit whose combinations are to be made
     * @param index index of the selected digit
     * @param currentCombination current going combination
     * @param combinations contains all the possible combination
     */
    private void helper(String digit, int index, StringBuilder currentCombination, List<String> combinations) {
        if (index == digit.length()) {
            combinations.add(currentCombination.toString());
            return;
        }

        String letters = digitToLetterMap.get(digit.charAt(index));
        for (char letter : letters.toCharArray()) {
            // adding the character
            currentCombination.append(letter);
            helper(digit, index+1, currentCombination, combinations);
            // removing the character
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}
