package com.dsa.practice.algo.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RatInMazeTest {

    private RatInMaze sut;

    @BeforeEach
    void init() {
        sut = new RatInMaze();
    }

    @Test
    public void testFindPath() {
        List<List<Integer>> mat = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        firstRow.add(0);
        firstRow.add(0);
        firstRow.add(0);
        mat.add(firstRow);

        List<Integer> secondRow = new ArrayList<>();
        secondRow.add(1);
        secondRow.add(1);
        secondRow.add(0);
        secondRow.add(1);
        mat.add(secondRow);

        List<Integer> thirdRow = new ArrayList<>();
        thirdRow.add(1);
        thirdRow.add(1);
        thirdRow.add(0);
        thirdRow.add(0);
        mat.add(thirdRow);

        List<Integer> fourthRow = new ArrayList<>();
        fourthRow.add(0);
        fourthRow.add(1);
        fourthRow.add(1);
        fourthRow.add(1);
        mat.add(fourthRow);

        List<String> expected = new ArrayList<>();
        expected.add("DDRDRR");
        expected.add("DRDDRR");

        List<String> path = sut.findPath(mat);

        Assertions.assertEquals(expected, path);
    }

    @Test
    public void testCase2() {
        List<List<Integer>> mat = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        firstRow.add(1);
        firstRow.add(1);
        firstRow.add(0);
        firstRow.add(1);
        mat.add(firstRow);

        List<Integer> secondRow = new ArrayList<>();
        secondRow.add(1);
        secondRow.add(0);
        secondRow.add(1);
        secondRow.add(1);
        secondRow.add(1);
        mat.add(secondRow);

        List<Integer> thirdRow = new ArrayList<>();
        thirdRow.add(0);
        thirdRow.add(0);
        thirdRow.add(1);
        thirdRow.add(1);
        thirdRow.add(1);
        mat.add(thirdRow);

        //[[1,1,1,0,1],[1,0,1,1,1],[0,0,1,1,1],[1,0,0,1,1],[1,0,0,0,1]]
        List<Integer> fourthRow = new ArrayList<>();
        fourthRow.add(1);
        fourthRow.add(0);
        fourthRow.add(0);
        fourthRow.add(1);
        fourthRow.add(1);
        mat.add(fourthRow);

        List<Integer> fifthRow = new ArrayList<>();
        fifthRow.add(1);
        fifthRow.add(0);
        fifthRow.add(0);
        fifthRow.add(0);
        fifthRow.add(1);
        mat.add(fifthRow);

        List<String> expected = new ArrayList<>();
        expected.add("RRDDRDRD");
        expected.add("RRDDRRDD");
        expected.add("RRDDRURDDD");
        expected.add("RRDRDDRD");
        expected.add("RRDRDRDD");
        expected.add("RRDRRDDD");
        expected.add("RRDRRDLDRD");

        List<String> actual = sut.findPath(mat);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }
}