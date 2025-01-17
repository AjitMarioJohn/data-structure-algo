package com.dsa.practice.algo.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeautifulArrangementTest {

    private BeautifulArrangement sut;

    @BeforeEach
    void setUp() {
        sut = new BeautifulArrangement();
    }

    @Test
    public void testCountArrangement_whenNIsOne() {
        assertEquals(1, sut.countArrangement(1));
    }

    @Test
    public void testCountArrangement_whenNIsTwo() {
        assertEquals(2, sut.countArrangement(2));
    }

    @Test
    public void testCountArrangement_whenNIsTwelve() {
        assertEquals(4010, sut.countArrangement(12));
    }
}