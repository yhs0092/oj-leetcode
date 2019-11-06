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
public class AddTwoNumbers implements IAddTwoNumbers {
  @Override
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head1 = l1;
    ListNode head2 = l2;
    boolean add = false;
    while (true) {
      int temp = l1.val + l2.val;
      if (add) {
        ++temp;
      }
      if (temp > 9) {
        add = true;
        temp -= 10;
      } else {
        add = false;
      }
      l1.val = temp;
      l2.val = temp;
      if (null == l1.next || null == l2.next) {
        break;
      }
      l1 = l1.next;
      l2 = l2.next;
    }

    ListNode result;
    ListNode l;
    if (null == l1.next) {
      l = l2;
      result = head2;
    } else {
      l = l1;
      result = head1;
    }
    if (!add) {
      return result;
    }

    while (true) {
      if (null == l.next) {
        l.next = new ListNode(0);
        l = l.next;
      } else {
        l = l.next;
      }
      ++l.val;
      if (l.val < 10) {
        add = false;
        break;
      }
      l.val -= 10;
    }
    return result;
  }
}
