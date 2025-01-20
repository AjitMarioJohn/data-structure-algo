package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * <p>
 *  Example 1:
 *
 *  Input: n = 3
 *  Output: ["((()))","(()())","(())()","()(())","()()()"]
 * </p>
 * <p>
 *  Example 2:
 *
 *  Input: n = 1
 *  Output: ["()"]
 * </p>
 *
 *
 * <p>
 *  Constraints: 1 <= n <= 8
 * </p>
 */
public class Parenthesis {
    /**
     * Finds out all the possible combination of well-formed parenthesis
     * @param numberOfParenthesis total number of well-formed parenthesis needed
     * @return @{@link List} List of all the possible combinations
     */
    public List<String> generate(final int numberOfParenthesis) {
        List<String> parenthesis = new ArrayList<>();
        generateAll("", parenthesis, 0, 0, numberOfParenthesis);
        return parenthesis;
    }

    /**
     * recursive method to find all the possible combination of well-formed parenthesis
     *
     * @param current current combination of the parenthesis
     * @param parenthesis contains all the well-formed parenthesis
     * @param openCount total number of open bracket in current combination
     * @param closeCount total number of close bracket in current combination
     * @param numberOfParenthesis total number of well-formed parenthesis needed
     */
    private void generateAll(String current, List<String> parenthesis, int openCount, int closeCount, int numberOfParenthesis) {
        // since we require open and close bracket base condition we multiple by 2
        if (current.length() == numberOfParenthesis * 2) {
            parenthesis.add(current);
            return;
        }

        if (openCount < numberOfParenthesis) {
            generateAll(current + "(", parenthesis, openCount + 1, closeCount, numberOfParenthesis);
        }

        if (closeCount < openCount) {
            generateAll(current + ")", parenthesis, openCount, closeCount + 1, numberOfParenthesis);
        }
    }
}
