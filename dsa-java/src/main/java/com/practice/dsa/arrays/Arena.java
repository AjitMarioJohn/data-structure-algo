package com.practice.dsa.arrays;

import java.util.Arrays;

/**
 * NODE 1 — ARRAYS · BUILD ARENA
 *
 * Fill in the methods marked TODO. Don't touch the runner below.
 * When ready, tell me "run it" and I execute:  java Arena.java
 * I'll show PASS/FAIL per case and the exact input that broke.
 *
 * Rules: in-place where stated, no extra libraries, mind edge cases
 * (empty, single element, k bigger than length, all zeros...).
 */
public class Arena {

    // WARM-UP — reverse the array in place. O(1) extra space.
    static void reverse(int[] a) {
        int arrLength = a.length;
        int leftPointer = 0;
        int rightPointer = arrLength - 1;

        while (rightPointer > leftPointer) {
            // int temp = a[rightPointer]+a[leftPointer];
            // above approach may give overflow error
            int temp = a[rightPointer];
            a[rightPointer] = a[leftPointer];
            a[leftPointer] = temp;
            rightPointer--;
            leftPointer++;
        }
    }

    // CORE — rotate array right by k, in place, O(1) extra space.
    // e.g. [1,2,3,4,5], k=2  ->  [4,5,1,2,3]
    static void rotateRight(int[] a, int k) {
        if (a == null || a.length < 2 || k == 0) {
            return;
        }

//        int arrLength = a.length;
//        int[] result = new int[arrLength];
//
//        for (int i = 0; i < arrLength; i++) {
//            int resultantIndex = (i + k) % arrLength;
//            result[resultantIndex] = a[i];
//        }
//        System.arraycopy(result, 0, a, 0, arrLength);


    }

    // SPICY — move all zeros to the end, keep order of non-zeros. In place.
    // e.g. [0,1,0,3,12] -> [1,3,12,0,0]
    static void moveZeros(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }

        int insertPos = 0;

        int arrLength = a.length;
        for (int index = 0; index < arrLength; index++) {
            if (a[index] != 0){
                a[insertPos++] = a[index];
            }
        }

        while (insertPos < arrLength) {
            a[insertPos++] = 0;
        }
    }

    // ============ TEST RUNNER (do not edit) ============
    static int pass = 0, fail = 0;

    static void check(String name, int[] got, int[] want) {
        if (Arrays.equals(got, want)) { pass++; System.out.println("  PASS " + name); }
        else { fail++; System.out.println("  FAIL " + name + "  got=" + Arrays.toString(got) + " want=" + Arrays.toString(want)); }
    }

    static int[] rev(int[] a){ int[] c=a.clone(); reverse(c); return c; }
    static int[] rot(int[] a,int k){ int[] c=a.clone(); rotateRight(c,k); return c; }
    static int[] mz(int[] a){ int[] c=a.clone(); moveZeros(c); return c; }

    public static void main(String[] args) {
        System.out.println("== reverse ==");
        check("empty", rev(new int[]{}), new int[]{});
        check("single", rev(new int[]{7}), new int[]{7});
        check("even", rev(new int[]{1,2,3,4}), new int[]{4,3,2,1});
        check("odd", rev(new int[]{1,2,3,4,5}), new int[]{5,4,3,2,1});

        System.out.println("== rotateRight ==");
        check("basic", rot(new int[]{1,2,3,4,5},2), new int[]{4,5,1,2,3});
        check("k=0", rot(new int[]{1,2,3},0), new int[]{1,2,3});
        check("k>len", rot(new int[]{1,2,3},5), new int[]{2,3,1});
        check("single", rot(new int[]{9},3), new int[]{9});

        System.out.println("== moveZeros ==");
        check("mixed", mz(new int[]{0,1,0,3,12}), new int[]{1,3,12,0,0});
        check("noZeros", mz(new int[]{1,2,3}), new int[]{1,2,3});
        check("allZeros", mz(new int[]{0,0,0}), new int[]{0,0,0});
        check("leadTrail", mz(new int[]{0,0,1}), new int[]{1,0,0});

        System.out.println("\nSCORE: " + pass + " pass / " + fail + " fail");
        if (fail == 0) System.out.println("ALL GREEN — node beat BUILD cleared. +XP");
    }
}
