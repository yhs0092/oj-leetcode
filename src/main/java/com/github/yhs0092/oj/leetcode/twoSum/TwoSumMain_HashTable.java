package com.github.yhs0092.oj.leetcode.twoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumMain_HashTable implements TwoSum {
  public int[] twoSum(int[] nums, int target) {
    final int[] result = new int[2];
    // num:index_of_num
    final Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      int num = nums[i];
      int toFind = target - num;
      Integer toFindIndex = map.get(toFind);
      if (null != toFindIndex) {
        result[0] = toFindIndex;
        result[1] = i;
        return result;
      }
      map.put(num, i);
    }

    return result;
  }
}
