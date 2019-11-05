package com.github.yhs0092.oj.leetcode.twoSum;

/**
 * 从输入来看target范围是[-2<sup>31</sup>,2<sup>31</sup>-1]，总计 2<sup>32</sup> 个数字。
 * 可以用数组按bit位存储数字是否出现过。需要 2<sup>29</sup> byte的空间，即512MB。
 */
public class TwoSumMain_BitMap implements TwoSum {

  private static final int UNIT_SIZE = 8;

  public int[] twoSum(int[] nums, int target) {
    final int[] result = new int[2];
    byte[] positive = new byte[1 << 28];
    byte[] negative = new byte[1 << 28];

    int i = 0;
    int aimValue = 0;
    while (i < nums.length) {
      final int num = nums[i];
      aimValue = target - num;
      boolean hit;
      if (aimValue < 0) {
        hit = hit(negative, -(aimValue + 1));
      } else {
        hit = hit(positive, aimValue);
      }
      if (hit) {
        result[1] = i;
        break;
      }

      if (num < 0) {
        mark(negative, -(num + 1));
      } else {
        mark(positive, num);
      }
      ++i;
    }

    for (int j = 0; j < i; ++j) {
      if (aimValue == nums[j]) {
        result[0] = j;
        break;
      }
    }

    return result;
  }

  private boolean hit(byte[] bitCache, int aimValue) {
    final int unitIndex = aimValue / UNIT_SIZE;
    final int maskValue = 1 << aimValue % UNIT_SIZE;
    return (bitCache[unitIndex] & maskValue) > 0;
  }

  private void mark(byte[] bitCache, int num) {
    bitCache[num / UNIT_SIZE] |= (1 << (num % UNIT_SIZE));
  }
}
