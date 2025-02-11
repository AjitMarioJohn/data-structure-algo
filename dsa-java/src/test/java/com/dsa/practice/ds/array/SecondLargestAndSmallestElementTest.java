package com.dsa.practice.ds.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SecondLargestAndSmallestElementTest {

    private SecondLargestAndSmallestElement sut;

    @BeforeEach
    void setUp() {
        sut = new SecondLargestAndSmallestElement();
    }

    @ParameterizedTest
    @MethodSource("inputs")
    public void testFind(int[] nums, int[] expected) {
        assertArrayEquals(expected, sut.find(nums));
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 4, 7, 7, 5}, new int[] {2, 7}),
                Arguments.of(new int[] {3, 4, 5, 2}, new int[] {3, 4})
        );
    }
}