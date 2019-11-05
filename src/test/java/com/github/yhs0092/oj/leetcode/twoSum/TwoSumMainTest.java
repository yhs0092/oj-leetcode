package com.github.yhs0092.oj.leetcode.twoSum;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class TwoSumMainTest {
  @Test
  public void testTwoSumMain() {
    for (int i = 0; i < 3; ++i) {
      TwoSum twoSumMain = new TwoSumMain();
      testUnit(twoSumMain);
      twoSumMain = new TwoSumMain_HashTable();
      testUnit(twoSumMain);
      twoSumMain = new TwoSumMain_BitMap();
      testUnit(twoSumMain);
    }

    TwoSum twoSumMain;
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10; ++i) {
      twoSumMain = new TwoSumMain();
      testUnit(twoSumMain);
    }
    System.out.println("cost: " + (System.currentTimeMillis() - start));
    start = System.currentTimeMillis();
    for (int i = 0; i < 10; ++i) {
      twoSumMain = new TwoSumMain_HashTable();
      testUnit(twoSumMain);
    }
    System.out.println("cost: " + (System.currentTimeMillis() - start));
    start = System.currentTimeMillis();
    for (int i = 0; i < 10; ++i) {
      twoSumMain = new TwoSumMain_BitMap();
      testUnit(twoSumMain);
    }
    System.out.println("cost: " + (System.currentTimeMillis() - start));
  }

  private void testUnit(TwoSum twoSum) {
    verify(twoSum.twoSum(new int[] {1, 2, 3, 4, 5}, 4), 0, 2);
    verify(twoSum.twoSum(new int[] {0, 1, 2, 4, 5, 6}, 4), 0, 3);
    verify(twoSum.twoSum(new int[] {0, 1, 2, 4, -1, 6}, 7), 1, 5);
    verify(twoSum.twoSum(new int[] {6, 5, 4, -2, -1, 1, 0}, 7), 0, 5);
    verify(twoSum.twoSum(new int[] {0, 1, 2, 2, 5, 6}, 4), 2, 3);
    verify(twoSum.twoSum(new int[] {-1, -2, -3, -4, -5}, -8), 2, 4);
    verify(twoSum.twoSum(new int[] {-1, -2, 3, -4, -5}, 1), 1, 2);
    verify(twoSum.twoSum(new int[] {Integer.MIN_VALUE, -2, -3, -4, Integer.MAX_VALUE - 3, Integer.MAX_VALUE ^ (1 << 13),
        Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE}, -1), 0, 8);

    final int[] nums = new int[1000_0000];
    final int positiveBoarder = nums.length - 1;
    for (int i = 0; i < positiveBoarder; ++i) {
      nums[i] = positiveBoarder - i;
    }
    nums[nums.length - 1] = -nums[nums.length - 2] - 2;
    verify(twoSum.twoSum(nums, -2), nums.length - 2, nums.length - 1);
  }

  private void verify(int[] result, int expected0, int expected1) {
    assertEquals(Arrays.toString(result), expected0, result[0]);
    assertEquals(Arrays.toString(result), expected1, result[1]);
  }
}