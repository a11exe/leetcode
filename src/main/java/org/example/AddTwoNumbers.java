package org.example;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int add = 0;
        if (sum > 9) {
            sum = sum - 10;
            add = 1;
        }
        ListNode result = new ListNode(sum);
        ListNode nextResult = result;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null || l2 != null) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
            if (sum > 9) {
                sum = sum - 10;
                add = 1;
            } else {
                add = 0;
            }
            nextResult.next = new ListNode(sum);
            nextResult = nextResult.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (add == 1) {
            nextResult.next = new ListNode(add);
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
            this.next = null;
            this.val = 0;
        }

        public ListNode(int x) {
            this.next = null;
            this.val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
