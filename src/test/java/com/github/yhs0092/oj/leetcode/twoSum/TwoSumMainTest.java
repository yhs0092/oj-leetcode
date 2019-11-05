package com.github.yhs0092.oj.leetcode.twoSum;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class TwoSumMainTest {
  @Test
  public void testTwoSumMain() {
    TwoSumMain twoSumMain = new TwoSumMain();
    verify(twoSumMain.twoSum(new int[] {1, 2, 3, 4, 5}, 4), 0, 2);
    verify(twoSumMain.twoSum(new int[] {0, 1, 2, 4, 5, 6}, 4), 0, 3);
    verify(twoSumMain.twoSum(new int[] {0, 1, 2, 4, -1, 6}, 7), 1, 5);
    verify(twoSumMain.twoSum(new int[] {6, 5, 4, -2, -1, 1, 0}, 7), 0, 5);
    verify(twoSumMain.twoSum(new int[] {0, 1, 2, 2, 5, 6}, 4), 2, 3);
    verify(twoSumMain.twoSum(new int[] {-1, -2, -3, -4, -5}, -8), 2, 4);
    verify(twoSumMain.twoSum(new int[] {-1, -2, 3, -4, -5}, 1), 1, 2);
  }

  private void verify(int[] result, int expected0, int expected1) {
    assertEquals(Arrays.toString(result), expected0, result[0]);
    assertEquals(Arrays.toString(result), expected1, result[1]);
  }
}