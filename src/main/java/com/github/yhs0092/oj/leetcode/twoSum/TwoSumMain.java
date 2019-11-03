package com.github.yhs0092.oj.leetcode.twoSum;

import java.util.Arrays;

/**
 * 两数之和
 */
public class TwoSumMain {
  public int[] twoSum(int[] nums, int target) {
    int[] sortedNums = getSortedNums(nums);

    int boarder = locateSearchBoarder(target, sortedNums);

    int largeNumIndex = boarder;
    int smallNumIndex = 0;
    while (largeNumIndex > 0) {
      while (target > sortedNums[smallNumIndex] + sortedNums[largeNumIndex]) {
        ++smallNumIndex;
      }
      if (target == sortedNums[smallNumIndex] + sortedNums[largeNumIndex]) {
        break;
      }
      smallNumIndex = 0;
      --largeNumIndex;
    }

    int firstIndex = findRawIndexByValue(nums, sortedNums[smallNumIndex], -1);
    int secondIndex = findRawIndexByValue(nums, sortedNums[largeNumIndex], firstIndex);
    return firstIndex < secondIndex ? new int[] {firstIndex, secondIndex} : new int[] {secondIndex, firstIndex};
  }

  private int locateSearchBoarder(int target, int[] sortedNums) {
    return sortedNums.length - 1;
  }

  private int[] getSortedNums(int[] nums) {
    int[] sortedNums = Arrays.copyOf(nums, nums.length);
    Arrays.sort(sortedNums);
    return sortedNums;
  }

  private int findRawIndexByValue(int[] nums, int sortedNum, int excludeIndex) {
    for (int i = 0; i < nums.length; ++i) {
      if (excludeIndex == i) {
        continue;
      }
      if (nums[i] == sortedNum) {
        return i;
      }
    }
    return -1;
  }
}
