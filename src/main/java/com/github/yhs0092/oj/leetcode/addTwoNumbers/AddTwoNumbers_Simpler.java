package com.github.yhs0092.oj.leetcode.addTwoNumbers;

/**
 * 两数相加
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers_Simpler implements IAddTwoNumbers {
  @Override
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    final ListNode result = l1;
    boolean add = false;
    while (true) {
      if (add) {
        ++l1.val;
        add = false;
      }
      if (null != l2) {
        l1.val += l2.val;
      }
      if (l1.val > 9) {
        add = true;
        l1.val -= 10;
      }

      if (null != l2) {
        l2 = l2.next;
      }
      if (null == l2 && !add) {
        break;
      }
      if (null == l1.next) {
        l1.next = null == l2
            ? new ListNode(0) : l2;
        l2 = null;
      }
      l1 = l1.next;
    }
    return result;
  }
}
