package com.dsa.practice.algo.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ParenthesisTest {

    private Parenthesis sut;

    @BeforeEach
    void setUp() {
        sut = new Parenthesis();
    }

    @Test
    public void testParenthesis_whenNumberIsThree() {
        List<String> expected = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
        List<String> actual = sut.generate(3);
        System.out.println(actual);
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testParenthesis_whenNumberIsOne() {
        List<String> expected = List.of("()");
        List<String> actual = sut.generate(1);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }
}