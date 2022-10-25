package org.example;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = null;
        ListNode last = null;
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                last = addResult(last, list2.val);
                list2 = list2.next;
                continue;
            }
            if (list2 == null) {
                last = addResult(last, list1.val);
                list1 = list1.next;
                continue;
            }
            if (list1.val < list2.val) {
                last = addResult(last, list1.val);
                if (head == null) {
                    head = last;
                }
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                last = addResult(last, list2.val);
                if (head == null) {
                    head = last;
                }
                list2 = list2.next;
            } else {
                last = addResult(last, list1.val);
                if (head == null) {
                    head = last;
                }
                last = addResult(last, list2.val);
                list1 = list1.next;
                list2 = list2.next;
            }
        }

        return head;
    }

    private ListNode addResult(ListNode result, int val) {
        if (result == null) {
            return new ListNode(val);
        } else {
            result.next = new ListNode(val);
            return result.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
