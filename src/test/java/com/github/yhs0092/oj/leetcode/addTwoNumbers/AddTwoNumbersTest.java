package com.github.yhs0092.oj.leetcode.addTwoNumbers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddTwoNumbersTest {
  @Test
  public void test() {
    testCase(new AddTwoNumbers());
    testCase(new AddTwoNumbers_Simpler());
  }

  public void testCase(IAddTwoNumbers addTwoNumbers) {
    testUnit(addTwoNumbers, 1234, 1111, "5432");
    testUnit(addTwoNumbers, 123, 6543, "6666");
    testUnit(addTwoNumbers, 6543, 123, "6666");
    testUnit(addTwoNumbers, 0, 1111, "1111");
    testUnit(addTwoNumbers, 1234, 0, "4321");
    testUnit(addTwoNumbers, 987, 123, "0111");
    testUnit(addTwoNumbers, 987, 99123, "011001");
    testUnit(addTwoNumbers, 987, 10003, "09901");
    testUnit(addTwoNumbers, 91111, 9001, "211001");
    testUnit(addTwoNumbers, 991111, 9001, "2110001");
  }

  private void testUnit(IAddTwoNumbers addTwoNumbers, int i1, int i2, String s) {
    assertEquals(s, toString(addTwoNumbers.addTwoNumbers(construct(i1), construct(i2))));
  }

  @Test
  public void construct() {
    ListNode result = construct(12345);
    assertEquals("54321", toString(result));
    result = construct(1234500);
    assertEquals("0054321", toString(result));
    result = construct(67890);
    assertEquals("09876", toString(result));
    result = construct(1230089);
    assertEquals("9800321", toString(result));
  }

  String toString(ListNode l) {
    final StringBuilder result = new StringBuilder();
    while (null != l) {
      result.append(l.val);
      l = l.next;
    }
    return result.toString();
  }

  ListNode construct(int i) {
    final ListNode result = new ListNode(i % 10);
    ListNode curr = result;
    i /= 10;
    while (i > 0) {
      curr.next = new ListNode(i % 10);
      curr = curr.next;
      i /= 10;
    }
    return result;
  }
}