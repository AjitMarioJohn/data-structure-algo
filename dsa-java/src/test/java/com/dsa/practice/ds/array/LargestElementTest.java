package com.dsa.practice.ds.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestElementTest {

    private LargestElement sut;

    @BeforeEach
    public void initialize() {
        sut = new LargestElement();
    }

    @ParameterizedTest
    @MethodSource("inputs")
    public void testFind(int[] nums, int expected) {
        assertEquals(expected, sut.find(nums));
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{2,5,1,3,0}, 5),
                Arguments.of(new int[]{8,10,5,7,9}, 10)
        );
    }
}